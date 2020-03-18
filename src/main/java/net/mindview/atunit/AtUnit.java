//: net/mindview/atunit/AtUnit.java
// An annotation-based unit-test framework.
// {RunByHand}
package net.mindview.atunit;

import net.mindview.util.BinaryFile;
import net.mindview.util.ProcessFiles;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

public class AtUnit implements ProcessFiles.Strategy {

    static Class<?> testClass;  //测试的类对象
    static List<String> failedTests = new ArrayList<String>(); //失败的测试
    static long testsRun = 0; //运行次数
    static long failures = 0; //失败个数

    public static void main(String[] args) throws Exception {

        //加载系统类  使用断言
        // 设置此类加载器的默认断言状态。此设置确定由此类加载器加载并在将来初始化的类在默认情况下是启用还是禁用断言
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true); // Enable asserts
        //在AtUnitExample1运行java -ea 会导致断言失败    //assert 1==2;
        //默认构造器  传入实现了Strategy的实现类  直接查找class
        //更简单的是直接传入class文件，而不需要处理文件的工具类
        new ProcessFiles(new AtUnit(), "class").start(args);

        //全部测试通过
        if (failures == 0) {
            print("OK (" + testsRun + " tests)");
        } else {
            //有失败
            print("(" + testsRun + " tests)");
            //失败数大于1  则加上S
            print("\n>>> " + failures + " FAILURE" + (failures > 1 ? "S" : "") + " <<<");
            for (String failed : failedTests) {
                print("  " + failed);
            }
        }
    }

    public void process(File cFile) {
        try {
            //从class文件中查找类名
            String cName = ClassNameFinder.thisClass(BinaryFile.read(cFile));
            //没有.退出
            if (!cName.contains(".")) {
                return; // Ignore unpackaged classes
            }
            //加载类
            testClass = Class.forName(cName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //测试容器,因为继承了ArrayList
        TestMethods testMethods = new TestMethods();
        //创建方法
        Method creator = null;
        //清除方法
        Method cleanup = null;
        for (Method m : testClass.getDeclaredMethods()) {

            testMethods.addIfTestMethod(m);

            if (creator == null) {
                //是不是创建对象方法 ，默认构造参数
                creator = checkForCreatorMethod(m);
            }
            if (cleanup == null) {
                //是不是清除对象方法
                cleanup = checkForCleanupMethod(m);
            }
        }

        if (testMethods.size() > 0) {
            if (creator == null) {
                try {
                    if (!Modifier.isPublic(testClass.getDeclaredConstructor().getModifiers())) {
                        print("Error: " + testClass + " default constructor must be public");
                        System.exit(1);
                    }
                } catch (NoSuchMethodException e) {
                    // Synthesized default constructor; OK
                }
                print(testClass.getName());
            }
        }

        //循环每一个测试方法
        for (Method m : testMethods) {
            printnb("  . " + m.getName() + " ");

            try {
                //创建测试对象
                Object testObject = createTestObject(creator);
                boolean success = false;
                try {
                    if (m.getReturnType().equals(boolean.class)) {
                        //boolean类型检查
                        success = (Boolean) m.invoke(testObject);
                    } else {
                        m.invoke(testObject);
                        success = true; // If no assert fails
                    }
                } catch (InvocationTargetException e) {
                    // Actual exception is inside e:
                    print(e.getCause());
                }

                print(success ? "" : "(failed)");
                testsRun++;
                if (!success) {
                    failures++;
                    //失败：类名+方法名
                    failedTests.add(testClass.getName() + ": " + m.getName());
                }
                //如果测试类有清除功能
                if (cleanup != null) {
                    cleanup.invoke(testObject, testObject);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class TestMethods extends ArrayList<Method> {
        //找有Test类型的注解
        void addIfTestMethod(Method m) {
            if (m.getAnnotation(Test.class) == null) {
                return;
            }
            //方法要么返回boolean，要么为void
            if (!(m.getReturnType().equals(boolean.class) || m.getReturnType().equals(void.class))) {
                throw new RuntimeException("@Test method must return boolean or void");
            }
            //可以访问私有方法
            m.setAccessible(true); // In case it's private, etc.
            add(m);
        }
    }

    /**
     * 是不是创建对象方法
     * @param m
     * @return
     */
    private static Method checkForCreatorMethod(Method m) {
        if (m.getAnnotation(TestObjectCreate.class) == null) {
            return null;
        }
        if (!m.getReturnType().equals(testClass)) {
            throw new RuntimeException("@TestObjectCreate must return instance of Class to be tested");
        }
        //创建对象方法必须为静态
        if ((m.getModifiers() & Modifier.STATIC) < 1) {
            throw new RuntimeException("@TestObjectCreate must be static.");
        }
        m.setAccessible(true);
        return m;
    }

    /**
     * 检查要不要清除方法
     * @param m
     * @return
     */
    private static Method checkForCleanupMethod(Method m) {
        if (m.getAnnotation(TestObjectCleanup.class) == null) {
            return null;
        }
        if (!m.getReturnType().equals(void.class)) {
            //清除方法必须有返回值
            throw new RuntimeException("@TestObjectCleanup must return void");
        }
        if ((m.getModifiers() & Modifier.STATIC) < 1) {
            throw new RuntimeException("@TestObjectCleanup must be static.");
        }
        // 第一个参数对象
        if (m.getParameterTypes().length == 0 || m.getParameterTypes()[0] != testClass) {
            //必须要传入参数，而且是测试类的参数
            throw new RuntimeException("@TestObjectCleanup must take an argument of the tested type.");
        }
        m.setAccessible(true);
        return m;
    }

    /**
     * 创建测试对象
     * @param creator
     * @return
     */
    private static Object createTestObject(Method creator) {
        if (creator != null) {
            try {
                return creator.invoke(testClass);
            } catch (Exception e) {
                throw new RuntimeException("Couldn't run @TestObject (creator) method.");
            }
        } else { // Use the default constructor:
            try {
                return testClass.newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Couldn't create a test object. Try using a @TestObject method.");
            }
        }
    }
} ///:~
