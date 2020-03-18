package arrays;//: arrays/MultidimensionalPrimitiveArray.java
// Creating multidimensional arrays.

import java.util.*;


public class MultidimensionalPrimitiveArray {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3,},
                {4, 5, 6,},
        };

        System.out.println(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.deepToString(a));

        int [][][] b = {
                {
                    {1,2,3},
                    {5,7},
                    {2,4,5}
                },
                {
                    {1,2,3},
                    {4,5,6,7}
                }
        };

        System.out.println(b);
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.deepToString(b));

        int [][] c = new int[3][];
        System.out.println(c);
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.deepToString(c));

        int[][] d = new int[3][4];
        System.out.println(d);
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.deepToString(d));
    }
} /* Output:
[[I@5aaa6d82
[[I@6f75e721, [I@69222c14]
[[1, 2, 3], [4, 5, 6]]
[[[I@606d8acf
[[[I@782830e, [[I@470e2030]
[[[1, 2, 3], [5, 7], [2, 4, 5]], [[1, 2, 3], [4, 5, 6, 7]]]
[[I@3fb4f649
[null, null, null]
[null, null, null]
[[I@33833882
[[I@200a570f, [I@16b3fc9e, [I@e2d56bf]
[[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]
*///:~
