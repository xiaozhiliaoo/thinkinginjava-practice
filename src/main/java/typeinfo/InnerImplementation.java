//: typeinfo/InnerImplementation.java
// Private inner classes can't hide from reflection.
package typeinfo;

import typeinfo.interfacea.*;

import static net.mindview.util.Print.*;

class InnerA {

//    静态内部类
    private static class C implements A {

        public void f() {
            print("public C.f()");
        }

        public void g() {
            print("public C.g()");
        }

        void u() {
            print("package C.u()");
        }

        protected void v() {
            print("protected C.v()");
        }

        private void w() {
            print("private C.w()");
        }
    }


    public static A makeA() {
        return new C();
    }
}

public class InnerImplementation {

    public static void main(String[] args) throws Exception {
//        内部类
        A a = InnerA.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        System.out.println(a.getClass().getSimpleName());
        // Reflection still gets into the private class:
        HiddenImplementation.callHiddenMethod(a, "g");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
    }
} /* Output:
public C.f()
InnerA$C
public C.g()
package C.u()
protected C.v()
private C.w()
*///:~
