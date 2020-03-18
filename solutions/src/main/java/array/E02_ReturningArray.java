package array;

import java.util.Arrays;

/**
 * @packgeName: array
 * @ClassName: E02_ReturningArray
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/15-21:20
 * @version: 1.0
 * @since: JDK 1.8
 */
public class E02_ReturningArray {

    public static BerylliumSphere[] createArray(int size) {
        BerylliumSphere[] s = new BerylliumSphere[size];
        for (int i = 0; i < s.length; i++) {
            s[i] = new BerylliumSphere();
        }
        return s;
    }

    public static BerylliumSphere[] createNullArray(int size) {
        return new BerylliumSphere[size];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(createArray(4)));
        System.out.println(Arrays.toString(createNullArray(4)));
    }
}
