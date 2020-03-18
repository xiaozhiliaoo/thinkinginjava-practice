//: net/mindview/atunit/AtUnitRemover.java
// Displays @Unit annotations in compiled class files. If
// first argument is "-r", @Unit annotations are removed.
// {Args: ..}
// {Requires: javassist.bytecode.ClassFile;
// You must install the Javassist library from
// http://sourceforge.net/projects/jboss/ }
package net.mindview.atunit;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.annotation.Annotation;
import net.mindview.util.BinaryFile;
import net.mindview.util.ProcessFiles;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import static net.mindview.util.Print.print;

/**
 * 移除测试代码  移除编译后class中的测试代码，不是源文件中的java文件
 * 当然也可以插入测试代码
 * 查找所有类中带有@XXX的方法，属性等等
 */
public class AtUnitRemover implements ProcessFiles.Strategy {

    private static boolean remove = false;

    public void process(File cFile) {

        boolean modified = false;

        try {

            //查找类名
            String cName = ClassNameFinder.thisClass(BinaryFile.read(cFile));
            if (!cName.contains(".")) {
                return; // Ignore unpackaged classes 忽略没有包的类
            }
            // 类池对象  默认的类池  类池中找类  A container of CtClass objects
            ClassPool cPool = ClassPool.getDefault();
            // 类池中获取类信息  CtClass 类的字节码对象
            // An instance of CtClass represents a class. It is obtained from ClassPool.
            CtClass ctClass = cPool.get(cName);
            for (CtMethod method : ctClass.getDeclaredMethods()) {
                MethodInfo mi = method.getMethodInfo();
                AnnotationsAttribute attr = (AnnotationsAttribute) mi.getAttribute(AnnotationsAttribute.visibleTag);
                if (attr == null) {
                    continue;
                }
                for (Annotation ann : attr.getAnnotations()) {
                    //删除的注解是atunit包下的注解
                    if (ann.getTypeName().startsWith("net.mindview.atunit")) {
                        print("Class: " + ctClass.getName() + " Method: " + mi.getName() + " " + ann);
                        // 给了-r就是删除，没有-r就是查看下
                        if (remove) {
                            ctClass.removeMethod(method);
                            //已经有过修改
                            modified = true;
                        }
                    }
                }
            }

            // Fields are not removed in this version (see text).
            if (modified) {
                //覆盖原始类文件
                ctClass.toBytecode(new DataOutputStream(new FileOutputStream(cFile)));
            }
            //释放资源  Removes this CtClass object from the ClassPool.
            ctClass.detach();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        // -r remove
        if (args.length > 0 && args[0].equals("-r")) {
            remove = true;
            // 指定参数  移除-r
            String[] nargs = new String[args.length - 1];
            // 传递参数拷贝进来  长度-1
            System.arraycopy(args, 1, nargs, 0, nargs.length);
            // 下面程序文件需要用
            args = nargs;
        }
        // 不希望把类的源文件暴露给用户
        //删除  -r D:\MavenSpace\thinkinjava\target\classes\annotations
        //查看所有的class ： D:\MavenSpace\thinkinjava\target\classes\annotations
        //删除完后再重新rebuild项目，重新生成带注解的class文件
        new ProcessFiles(new AtUnitRemover(), "class").start(args);
    }
} ///:~
/**
 * Exception in thread "main" java.lang.RuntimeException: javassist.NotFoundException: lili.queue.JMSConsumer
 why????
 */
