//: typeinfo/InterfaceViolation.java
// Sneaking around an interface.
package typeinfo;

import typeinfo.interfacea.*;

class B implements A {
    public void f() {
        System.out.println("f()");
    }

    public void g() {
        System.out.println("g()");
    }
}

public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        // a.g(); // Compile error
        //实际类型是B
        System.out.println(a.getClass().getName());
        if (a instanceof B) {
            B b = (B) a;
            b.g();
        }
    }
} /* Output:
f()
typeinfo.B
g()
*///:~
