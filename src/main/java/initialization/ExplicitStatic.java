//: initialization/ExplicitStatic.java
// Explicit static initialization with the "static" clause.
package initialization;
//P97

import static net.mindview.util.Print.*;

class Cup {

    Cup(int marker) {
        print("Cup(" + marker + ")");
    }

    void f(int marker) {
        print("f(" + marker + ")");
    }
}

class Cups {

    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1); // 1
        cup2 = new Cup(2); //  2
    }

    Cups() {
        print("Cups()");  // 3    4
    }
}

public class ExplicitStatic {
    public static void main(String[] args) {

        print("Inside main()");   //   5
        Cups.cup1.f(99);  // (1)   6
    }
     static Cups cups1 = new Cups();  // (2)
     static Cups cups2 = new Cups();  // (2)
} /* Output:
Cup(1)   1
Cup(2)   2
Cups()   3
Cups()   4
Inside main()   5
f(99)    6
*///:~
