//: arrays/TestGenerated.java
package arrays;

import net.mindview.util.CountingGenerator;
import net.mindview.util.Generated;

import java.util.Arrays;

public class TestGenerated {

    public static void main(String[] args) {

        Integer[] a = {9, 8, 7, 6};
        System.out.println(Arrays.toString(a));

        a = Generated.array(a, new CountingGenerator.Integer());
        System.out.println(Arrays.toString(a));

        Integer[] b = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);
        System.out.println(Arrays.toString(b));

        // 错误   数组不支持自动装箱机制
        //int[] c = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);

    }
} /* Output:
[9, 8, 7, 6]
[0, 1, 2, 3]
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
*///:~
