package exceptions;//: exceptions/ExceptionMethods.java
// Demonstrating the Exception Methods.

import static net.mindview.util.Print.*;

public class ExceptionMethods {

    public static void main(String[] args) {
        try {
            throw new Exception("My Exception ~~~");

        } catch (Exception e) {
            print("Caught Exception");
            print("e.getMessage():" + e.getMessage());//消息为My Exception ~~~
            //本地消息
            print("e.getLocalizedMessage():" + e.getLocalizedMessage());
            print("toString():" + e);//e默认调用toString();  查看Throwable的toString()方法
            print("printStackTrace():");
            //从main方法开始-从调用处开始
            e.printStackTrace(System.out);
            e.printStackTrace(); //默认调用System.err
        }
    }
} /* Output:
Caught Exception
getMessage():My Exception
getLocalizedMessage():My Exception
toString():java.lang.Exception: My Exception
printStackTrace():
java.lang.Exception: My Exception
        at ExceptionMethods.main(ExceptionMethods.java:8)
*///:~
