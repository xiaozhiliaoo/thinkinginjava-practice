//: arrays/AssemblingMultidimensionalArrays.java

// Creating multidimensional arrays.
package arrays;

import java.util.*;


public class AssemblingMultidimensionalArrays {
    public static void main(String[] args) {

        Integer[][] a;
        a = new Integer[3][];

        for (int i = 0; i < a.length; i++) {
            a[i] = new Integer[3];
            for (int j = 0; j < a[i].length; j++)
                a[i][j] = i * j; // Autoboxing
        }

        System.out.println(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.deepToString(a));
    }
} /* Output:
[[Ljava.lang.Integer;@73a28541
[[Ljava.lang.Integer;@6f75e721, [Ljava.lang.Integer;@69222c14, [Ljava.lang.Integer;@606d8acf]
[[0, 0, 0], [0, 1, 2], [0, 2, 4]]*///:~
