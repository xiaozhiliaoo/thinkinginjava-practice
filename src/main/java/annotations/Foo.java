package annotations;

import java.lang.reflect.Method;

/**
 * @packgeName: annotations
 * @ClassName: Foo
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/10-20:50
 * @version: 1.0
 * @since: JDK 1.8
 */
public class Foo {

    @TestFOO
    public static void m1() {
    }

    public static void m2() {
    }

    @TestFOO
    public static void m3() {
        throw new RuntimeException("Boom");
    }

    public static void m4() {
    }

    @TestFOO
    public static void m5() {
    }

    public static void m6() {
    }

    @TestFOO
    public static void m7() {
        throw new RuntimeException("Crash");
    }

    public static void m8() {
    }


    public static void main(String[] args) throws ClassNotFoundException {
        int passed = 0;
        int failed = 0;
        String className = "annotations.Foo";
        for (Method m : Class.forName(className).getMethods()) {
            //当前方法是是否有注解  两者等价
            //if (m.isAnnotationPresent(Test.class)) {
            if (m.getAnnotation(TestFOO.class) != null) {
                try {
                    // 测试的时候 m.invoke();  说明要执行这个方法
                    m.invoke(null);
                    passed++;
                } catch (Exception ex) {
                    System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }
}
