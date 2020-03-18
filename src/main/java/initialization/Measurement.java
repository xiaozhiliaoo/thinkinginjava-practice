//: initialization/Measurement.java
package initialization;

class Depth {
}

public class Measurement {
    Depth d = new Depth();

    public Measurement(Depth d) {
        this.d = d;
    }

    public static void main(String[] args) {
        Measurement m = new Measurement(new Depth());
    }
    // ...
} ///:~
