package exceptions;//: exceptions/WhoCalled.java
// Programmatic access to stack trace information.

public class WhoCalled {

    static void f() {
        // Generate an exception to fill in the stack trace
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("开始处理异常");
            //循环输出跟踪栈具体信息  打印栈轨迹[一层一层调用]  看Throwable.java源码的printStackTrace()
            for (StackTraceElement ste : e.getStackTrace()) {
                System.out.println(ste.getMethodName() + "----" +
                        ste.getClassName() + "-----" +
                        ste.getFileName()+"-----"+
                        ste.getLineNumber());
            }
            //e.printStackTrace();
        }
    }

    static void g() {
        f();
    }

    static void h() {
        g();
    }

    public static void main(String[] args) {
        f();
        System.out.println("--------------------------------");
        g();
        System.out.println("--------------------------------");
        //栈：先进后出  main是栈底层
        h();
    }
} /* Output:
f
main
--------------------------------
f
g
main
--------------------------------
f
g
h
main
*///:~
