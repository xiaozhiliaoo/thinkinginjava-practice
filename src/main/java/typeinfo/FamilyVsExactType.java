//: typeinfo/FamilyVsExactType.java
// The difference between instanceof and class
package typeinfo;

import static net.mindview.util.Print.*;

class Base {
}

class Derived extends Base {
}

public class FamilyVsExactType {

    public static void test(Object x) {

        String name = x.getClass().getSimpleName();
        print("" + name + " instanceof Base " + (x instanceof Base));
        print("" + name + " instanceof Derived " + (x instanceof Derived));
        print("Base.isInstance(" + name + ") " + Base.class.isInstance(x));
        print("Derived.isInstance(" + name + ") " + Derived.class.isInstance(x));
        print("" + name + ".getClass() == Base.class " + (x.getClass() == Base.class));
        print("" + name + ".getClass() == Derived.class " + (x.getClass() == Derived.class));
        print("" + name + ".getClass().equals(Base.class)) " + (x.getClass().equals(Base.class)));
        print("" + name + ".getClass().equals(Derived.class)) " + (x.getClass().equals(Derived.class)));
        print("-----------------------------------------------------------------");
    }

    public static void main(String[] args) {
        test(new Base());
        System.out.println("--------------------------------------------------");
        test(new Derived());
        print("Base.class.isAssignableFrom(Derived.class) " + Base.class.isAssignableFrom(Derived.class));
        print("Derived.class.isAssignableFrom(Base.class) " + Derived.class.isAssignableFrom(Base.class));

    }
} /* Output:
Testing x of type class typeinfo.Base
x instanceof Base true
x instanceof Derived false
Base.isInstance(x) true
Derived.isInstance(x) false
x.getClass() == Base.class true
x.getClass() == Derived.class false
x.getClass().equals(Base.class)) true
x.getClass().equals(Derived.class)) false
Testing x of type class typeinfo.Derived
x instanceof Base true
x instanceof Derived true
Base.isInstance(x) true
Derived.isInstance(x) true
x.getClass() == Base.class false
x.getClass() == Derived.class true
x.getClass().equals(Base.class)) false
x.getClass().equals(Derived.class)) true
*///:~
