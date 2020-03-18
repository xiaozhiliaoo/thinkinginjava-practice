//: containers/Groundhog.java
// Looks plausible, but doesn't work as a HashMap key.
package containers;


//Use for key 土拨鼠
public class Groundhog {
    protected int number;

    public Groundhog(int n) {
        number = n;
    }

    public String toString() {
        return "Groundhog #" + number;
    }
} ///:~
