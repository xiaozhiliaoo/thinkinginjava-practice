// typeinfo/SimpleProxyDemo21.java
// TIJ4 Chapter Typeinfo, Exercise 21, page 598
// Modify SimpleProxyDemo.java so that it measures method-call times.
package typeinfo;



import java.util.Date;

/**
 * @packgeName: typeinfo
 * @ClassName: SimpleProxyDemo21
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/8/27-18:36
 * @version: 1.0
 * @since: JDK 1.8
 */
interface Interface {

    void doSomething();

    void somethingElse(String args);
}


class RealObject implements Interface {
    public void doSomething() {
        System.out.println("doSomething");
    }

    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface{

    private Interface proxied;
    private static int doCount = 0;
    private static int sECount = 0;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    public void doSomething() {
        long timeIn = new Date().getTime();
        System.out.println("Time called doSomething() " + doCount + ": " + timeIn + " msecs");
        System.out.println("on " + new Date());
        doCount++;
        proxied.doSomething();
        //方法调用完后执行统计时间的方法
        System.out.println("Call-return time = " + ((new Date().getTime()) - timeIn) + " msecs");
    }

    public void somethingElse(String args) {
        long timeIn = new Date().getTime();
        System.out.println("Time called somethingElse() " + sECount + ": " + timeIn + " msecs");
        System.out.println("on " + new Date());
        sECount++;
        proxied.somethingElse(args);
        System.out.println("Call-return time = " + ((new Date().getTime()) - timeIn) + " msecs");
    }
}

public class SimpleProxyDemo21 {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        consumer(new RealObject());
        System.out.println();
        consumer(new SimpleProxy(new RealObject()));
        System.out.println();
        consumer(new SimpleProxy(new RealObject()));
        System.out.println();
        consumer(new SimpleProxy(new RealObject()));
    }
}
