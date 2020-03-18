package generics;//: generics/SelfBounding.java


class SelfBounded<T extends SelfBounded<T>> {

    T element;

    //返回自限定类型
    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}



class A extends SelfBounded<A> {

}


class B extends SelfBounded<A> {

} // Also OK


class C extends SelfBounded<C> {

    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}


class D {

}

// Can't do this:
// class E extends SelfBounded<D> {}
// Compile error: Type parameter D is not within its bound

// Alas, you can do this, so you can't force the idiom:
class F extends SelfBounded {
}

public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        B b = new B();
        b.set(new A());
        A a1 = b.get();
        a = a.set(new A()).get();
        a = a.get();
        C c = new C();
        c = c.setAndGet(new C());
    }
} ///:~
