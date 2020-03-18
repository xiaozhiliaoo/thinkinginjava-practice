package array;

import java.util.Arrays;

/**
 * @packgeName: array
 * @ClassName: E20_ArrayDeepEquals
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/16-20:52
 * @version: 1.0
 * @since: JDK 1.8
 */
public class E20_ArrayDeepEquals {
    public static void main(String[] args) {
        int[][] table1 = {{1, 2, 3}, {4, 5}, {7, 8, 9, 10}};
        int[][] table2 = {{1, 2, 3}, {4, 5}, {7, 8, 9, 10}};
        Integer[][] table3 = {{1, 2, 3}, {4, 5}, {7, 8, 9, 10}};
        int[][] table4 = {{1, 2, 3}, {6, 5, 4}, {7, 8}};
        System.out.println(Arrays.deepEquals(table1, table2)); //true
        System.out.println(Arrays.deepEquals(table1, table3)); //false
        System.out.println(Arrays.deepEquals(table1, table4)); //false

        System.out.println(Arrays.equals(table1, table2)); //false
        System.out.println(Arrays.equals(table1, table3)); //false
        System.out.println(Arrays.equals(table1, table4)); //false
    }
}
