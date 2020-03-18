package exceptions;//: exceptions/FullConstructors.java

class MyException extends Exception {
    //空就不会调用默认的了
    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }
}

public class FullConstructors {

    public static void f() throws LiLiException {

        System.out.println("Throwing MyException from f()");
        //发生错误位置  未传入消息
        throw new LiLiException();
    }

    public static void g() throws LiLiException {
        //传入消息
        System.out.println("Throwing MyException from g()");
        throw new LiLiException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (LiLiException e) {
            System.out.println("开始处理异常");
            e.printStackTrace(System.out);

        }
        System.out.println("----------------------------------------");
        try {
            g();
        } catch (LiLiException e) {
            e.printStackTrace(System.out);
        }
    }
} /* Output:
Throwing MyException from f()
MyException
        at FullConstructors.f(FullConstructors.java:11)
        at FullConstructors.main(FullConstructors.java:19)
Throwing MyException from g()
MyException: Originated in g()
        at FullConstructors.g(FullConstructors.java:15)
        at FullConstructors.main(FullConstructors.java:24)
*///:~
