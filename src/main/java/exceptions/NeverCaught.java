package exceptions;//: exceptions/NeverCaught.java
// Ignoring RuntimeExceptions.
// {ThrowsException}

public class NeverCaught {
    static void f() {
        throw new RuntimeException("From f()");
    }

    static void g() {
        f();
    }

    public static void main(String[] args) {
        //运行时候异常不用强制捕获，不用加try catch，说明是编程错误
        //继承了RuntimeException，也就不用try catch了
        g();
    }
} ///:~
