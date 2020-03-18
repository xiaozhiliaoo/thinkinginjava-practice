//: innerclasses/Parcel8.java
// Calling the base-class constructor.
package innerclasses;

public class Parcel8 {

    public Wrapping wrapping(int x) {
        // Base constructor call:
        return new Wrapping(x) { // Pass constructor argument.

//            private String name = "hi~~~~";
            //匿名子类重写方法
            public int value() {
                return super.value() * 47;
            }
        }; // Semicolon required
    }

    public static void main(String[] args) {

        Parcel8 p = new Parcel8();

        Wrapping w = p.wrapping(10);

        System.out.println(w.value());
    }
} ///:~
