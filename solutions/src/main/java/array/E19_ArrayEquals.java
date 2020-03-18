package array;

import java.util.Arrays;
import java.util.Objects;

/**
 * @packgeName: array
 * @ClassName: E19_ArrayEquals
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/16-20:22
 * @version: 1.0
 * @since: JDK 1.8
 */
class DataHolder {

    protected int data;
    DataHolder(int data) { this.data = data; }
}

class DataHolderWithEquals extends DataHolder {

    DataHolderWithEquals(int data) {
        super(data);
    }
    public boolean equals(Object o) {
        return  o instanceof DataHolderWithEquals && data == ((DataHolder)o).data;
        //return this == o ||  o instanceof DataHolderWithEquals && data == ((DataHolder)o).data;
    }
}

public class E19_ArrayEquals {

    public static void main(String[] args) {

        DataHolder[] a1 = new DataHolder[5];
        DataHolder[] a2 = new DataHolder[5];
        Arrays.fill(a1, new DataHolder(1));
        Arrays.fill(a2, new DataHolder(1));
        System.out.println(Arrays.equals(a1, a2));
        Arrays.fill(a1, new DataHolderWithEquals(1));
        Arrays.fill(a2, new DataHolderWithEquals(1));
        System.out.println(Arrays.equals(a1, a2));

        System.out.println(Objects.equals(a1, a2)); //false 必然false  数组比较用数组比较的方法，而不是对象比较的方法
        System.out.println(Objects.equals(new DataHolder(1),new DataHolder(1)));//false
        System.out.println(Objects.equals(new DataHolderWithEquals(1),new DataHolderWithEquals(1)));//true
        System.out.println(Objects.equals(1,1)); // true
    }
}
