//: arrays/ThreeDWithNew.java
package arrays;

import java.util.*;

public class ThreeDWithNew {
    public static void main(String[] args) {
        // 3-D array with fixed length:
        int[][][] a = new int[2][2][4];
        System.out.println(Arrays.deepToString(a));

        int[][][] b = new int[2][2][];
        System.out.println(Arrays.deepToString(b));
    }
}
/* Output:
[[[0, 0, 0, 0], [0, 0, 0, 0]], [[0, 0, 0, 0], [0, 0, 0, 0]]]
[[null, null], [null, null]]
*///:~
