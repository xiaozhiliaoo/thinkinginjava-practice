//: arrays/RaggedArray.java
package arrays;

import java.util.*;


/**
 * 参差不齐的数组
 */
public class RaggedArray {
    public static void main(String[] args) {

        Random rand = new Random(47);
        // 3-D array with varied-length vectors:  这种方式最常见  new int[]
        int[][][] a = new int[rand.nextInt(7)][][];

        for (int i = 0; i < a.length; i++) {
            a[i] = new int[rand.nextInt(5)][];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = new int[rand.nextInt(5)];
            }
        }

        System.out.println(Arrays.deepToString(a));
    }

} /* Output:
[[], [[0], [0], [0, 0, 0, 0]], [[], [0, 0], [0, 0]], [[0, 0, 0], [0], [0, 0, 0, 0]], [[0, 0, 0], [0, 0, 0], [0], []], [[0], [], [0]]]
*///:~
