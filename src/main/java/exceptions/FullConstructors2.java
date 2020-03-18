package exceptions;

/**
 * @packgeName: exceptions
 * @ClassName: FullConstructors2
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/8/19-12:04
 * @version: 1.0
 * @since: JDK 1.8
 */
class LiLiException extends Exception {
    //空就不会调用默认的了
    public LiLiException() {
    }

    public LiLiException(String msg) {
        super(msg);
    }
}

public class FullConstructors2 {

    public static void f() throws LiLiException {

        System.out.println("Throwing MyException from f()");
        throw new LiLiException();
    }

    public static void g() throws LiLiException {

        System.out.println("Throwing MyException from g()");
        throw new LiLiException("Originated in g()");
    }

    public static void main(String[] args) throws LiLiException {

        f();

        System.out.println("----------------------------------------");
        try {
            g();
        } catch (LiLiException e) {
            e.printStackTrace(System.out);
        }
    }
}

//因为main中并未对f()方法进行异常处理，而是将异常抛出给JVM，JVM中的main线程将处理此异常。
//main线程处理后，线程停止运行，导致程序结束，后面的g()就不会执行了。如果在main里面处理
//f()的异常，线程本身并没有终止运行，所以还会执行g()方法。可以通过debug查看main线程。

/* Output:
Exception in thread "main" exceptions.LiLiException
Throwing MyException from f()
	at exceptions.FullConstructors2.f(FullConstructors2.java:28)
	at exceptions.FullConstructors2.main(FullConstructors2.java:39)
*///:~

