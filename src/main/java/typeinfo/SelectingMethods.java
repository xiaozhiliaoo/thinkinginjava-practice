//: typeinfo/SelectingMethods.java
// Looking for particular methods in a dynamic proxy.
package typeinfo;

import java.lang.reflect.*;

import static net.mindview.util.Print.*;

class MethodSelector implements InvocationHandler {
    //所代理的真实对象
    private Object proxied;

    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //代理
        if (method.getName().equals("interesting")) {
            print("Proxy detected the interesting method");
        }
        return method.invoke(proxied, args);
    }
}

interface SomeMethods {

    void boring1();

    void boring2();

    void interesting(String arg);

    void boring3();
}

//
class Implementation implements SomeMethods {

    public void boring1() {
        print("boring1");
    }

    public void boring2() {
        print("boring2");
    }

    public void interesting(String arg) {
        print("interesting " + arg);
    }

    public void boring3() {
        print("boring3");
    }
}

class SelectingMethods {
    public static void main(String[] args) {
        //InvocationHandler属于回调的使用
        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(SomeMethods.class.getClassLoader(),
                new Class[]{SomeMethods.class},
                new MethodSelector(new Implementation()));
        proxy.boring1();
        proxy.boring2();
        //此方法会被拦截~~~
        proxy.interesting("bonobo");
        proxy.boring3();
    }
} /* Output:
boring1
boring2
Proxy detected the interesting method
interesting bonobo
boring3
*///:~
