//: containers/Prediction.java
// Predicting the weather with groundhogs.
package containers;

import java.util.*;

//Used for value
public class Prediction {
    private static Random rand = new Random(47);
    private boolean shadow = rand.nextDouble() > 0.5;

    public String toString() {
        if (shadow) {
            return "Six more weeks of Winter!";
        } else {
            return "Early Spring!";
        }
    }
} ///:~
