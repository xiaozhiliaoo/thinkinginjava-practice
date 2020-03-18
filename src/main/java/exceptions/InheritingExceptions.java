package exceptions;//: exceptions/InheritingExceptions.java
// Creating your own exceptions.

class SimpleException extends Exception {
}

public class InheritingExceptions {

    //f()方法里面不处理异常
    public void f() throws SimpleException {

        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {

        InheritingExceptions sed = new InheritingExceptions();
        try {
            //在main方法里面处理异常
            sed.f();
        } catch (SimpleException e) {
            System.out.println("Caught it!");
        }
        System.out.println("I Can Run Here！");
    }

    //抛给main方法--》抛给虚拟机[处理不了或者没处理]--》抛给操作系统--》抛给线程--》程序中断
    //每次tomcat都是从Thread.run开始抛出异常的
    /*public static void main(String[] args) throws SimpleException {
        InheritingExceptions sed = new InheritingExceptions();
            sed.f();
    }*/
} /* Output:
Throw SimpleException from f()
Caught it!
*///:~
