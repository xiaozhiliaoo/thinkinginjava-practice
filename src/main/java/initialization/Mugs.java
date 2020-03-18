//: initialization/Mugs.java
// Java "Instance Initialization."
package initialization;
//P98

import static net.mindview.util.Print.*;

class Mug {

    Mug(int marker) {
        print("Mug(" + marker + ")");  //2   3    7    8
    }

    void f(int marker) {
        print("f(" + marker + ")");
    }
}

public class Mugs {
    Mug mug1;
    Mug mug2;

    //加上static就是错的  因为static只能初始化static成员变量
    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        print("mug1 & mug2 initialized"); //  4    9
    }

    Mugs() {
        print("Mugs()");  // 5
    }

    Mugs(int i) {
        print("Mugs(int)"); //10
    }

    public static void main(String[] args) {

        print("Inside main()"); //1
        new Mugs();
        print("new Mugs() completed");  //6
        new Mugs(1);
        print("new Mugs(1) completed");//11
    }
} /* Output:
Inside main()   1
Mug(1)     2
Mug(2)   3
mug1 & mug2 initialized   4
Mugs()   5
new Mugs() completed   6
Mug(1)   7
Mug(2)   8
mug1 & mug2 initialized   9
Mugs(int)    10
new Mugs(1) completed  11
*///:~
