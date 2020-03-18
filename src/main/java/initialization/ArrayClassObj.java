//: initialization/ArrayClassObj.java
// Creating an array of nonprimitive objects.
package initialization;
//P100

import java.util.*;

import static net.mindview.util.Print.*;

public class ArrayClassObj {

    public static void main(String[] args) {
        Random rand = new Random(47);
        Integer[] a = new Integer[rand.nextInt(20)];
//        Integer[] a1 = new int[rand.nextInt(20)];   // error
//        Integer[] a2 = new int[]{1,2,3};

        print("length of a = " + a.length);
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(500); // Autoboxing
        }
        print(Arrays.toString(a));
    }
} /* Output: (Sample)
length of a = 18
[55, 193, 361, 461, 429, 368, 200, 22, 207, 288, 128, 51, 89, 309, 278, 498, 361, 20]
*///:~
