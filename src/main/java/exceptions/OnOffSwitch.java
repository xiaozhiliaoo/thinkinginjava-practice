package exceptions;//: exceptions/OnOffSwitch.java
// Why use finally?

public class OnOffSwitch {

    private static Switch sw = new Switch();

    public static void f() throws OnOffException1, OnOffException2 {

    }

    public static void main(String[] args) {
        try {
            sw.on();
            // Code that can throw exceptions...
            f();//方法什么都没做，没有异常发生。所以也就没有捕获
            sw.off();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
            sw.off();
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off();
        }
        //可以统一关闭开关  sw.off();
    }
} /* Output:
on
off
*///:~
