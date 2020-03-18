//: initialization/SimpleConstructor2.java
// Constructors can have arguments.
package initialization;

//P77
class Rock2 {

    Rock2(int i) {
        System.out.print("Rock " + i + " ");
    }

//    Rock2() { // This is the constructor
//        //这时候将不会默认调用了Rock2，必须要是new Rock2()
//        System.out.print("Rock ");
//    }
}

public class SimpleConstructor2 {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            new Rock2(i);
            //new Rock2(); //编译器不会自动识别了
        }
    }
} /* Output:
Rock 0 Rock 1 Rock 2 Rock 3 Rock 4 Rock 5 Rock 6 Rock 7
*///:~
