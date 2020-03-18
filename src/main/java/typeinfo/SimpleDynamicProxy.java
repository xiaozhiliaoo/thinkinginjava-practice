//: typeinfo/SimpleDynamicProxy.java
package typeinfo;

import java.lang.reflect.*;

class DynamicProxyHandler implements InvocationHandler {

    //所代理的真实对象
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //Debug at here
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println("  " + arg);
            }
        }
        //真实对象执行方法
        return method.invoke(proxied, args);
    }
}

class SimpleDynamicProxy {

    public static void consumer(Interface iface) {

        iface.doSomething();
        iface.somethingElse("bonobo");

    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        System.out.println("--------------------------------------------------------------");
        // Insert a proxy and call again:
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(real));
        proxy.doSomething();
        proxy.somethingElse("hi~~~");
        System.out.println("---------------------------------------------------------------");
        consumer(proxy);
    }
} /* Output: (95% match)	
doSomething
somethingElse bonobo
**** proxy: class $Proxy0, method: public abstract void Interface.doSomething(), args: null
doSomething
**** proxy: class $Proxy0, method: public abstract void Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@42e816
  bonobo
somethingElse bonobo
*///:~
