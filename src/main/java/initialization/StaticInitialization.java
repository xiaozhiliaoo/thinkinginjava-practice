package initialization;//: initialization/StaticInitialization.java
// Specifying initial values in a class definition.

import static net.mindview.util.Print.*;

/**
 * 碗
 */
class Bowl {

    Bowl(int marker) {
        print("Bowl(" + marker + ")");
    }

    void f1(int marker) {
        print("f1(" + marker + ")");
    }
}

/**
 * 桌子
 */
class Table {

    static Bowl bowl1 = new Bowl(1);

    Table() {
        print("Table()");
        bowl2.f1(1);
    }

    void f2(int marker) {
        print("f2(" + marker + ")");
    }

    static Bowl bowl2 = new Bowl(2);
}

/**
 * 橱柜
 */
class Cupboard {

    Bowl bowl3 = new Bowl(3);

    static Bowl bowl4 = new Bowl(4);

    Cupboard() {
        print("Cupboard()");
        bowl4.f1(2);
    }

    void f3(int marker) {
        print("f3(" + marker + ")");
    }

    static Bowl bowl5 = new Bowl(5);
}

public class StaticInitialization {

    public static void main(String[] args) {

        print("Creating new Cupboard() in main");
        new Cupboard();

        print("Creating new Cupboard() in main");
        new Cupboard();

        table.f2(1);
        cupboard.f3(1);
    }

    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
    //这里无论被实例化多少次，Bowl(3)随着实例化次数而增加，而静态的Bowl(4)Bowl(5)只会被实例化一次
    static Cupboard cupboard2 = new Cupboard();
    static Cupboard cupboard3 = new Cupboard();
    static Cupboard cupboard4 = new Cupboard();
    static Cupboard cupboard5 = new Cupboard();
    static Table table2 = new Table();

} /* Output:
Bowl(1)
Bowl(2)
Table()
f1(1)
Bowl(4)
Bowl(5)
Bowl(3)
Cupboard()
f1(2)
Bowl(3)
Cupboard()
f1(2)
Bowl(3)
Cupboard()
f1(2)
Bowl(3)
Cupboard()
f1(2)
Bowl(3)
Cupboard()
f1(2)
Table()
f1(1)
Creating new Cupboard() in main
Bowl(3)
Cupboard()
f1(2)
Creating new Cupboard() in main
Bowl(3)
Cupboard()
f1(2)
f2(1)
f3(1)
*///:~
