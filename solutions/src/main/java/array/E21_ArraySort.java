package array;

import net.mindview.util.Generated;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * @packgeName: array
 * @ClassName: E21_ArraySort
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/16-20:55
 * @version: 1.0
 * @since: JDK 1.8
 */
class ComparableBerylliumSphere extends BerylliumSphere implements Comparable<BerylliumSphere> {

    private long getID(BerylliumSphere sphere, String fieldName){
        try {
            Field field = sphere.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.getLong(sphere);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }


    @Override
    public int compareTo(BerylliumSphere o) {

        long thisid = getID(this,"id");
        long thatid = getID(o,"id");
        return thisid==thatid?0 : (thisid>thatid?1:-1);
    }
    // BerylliumSphere.id is private, so we need to use
// reflection to get its value.


}

public class E21_ArraySort {
    public static void main(String[] args) {
        Random r = new Random(47);
        BerylliumSphere[] a = Generated.array(BerylliumSphere.class, new BSGenerator(), 5);
        Collections.shuffle(Arrays.asList(a), r);
        print("Before sort 1: a = " + Arrays.toString(a));
        try {
            //此时候a数组元素没有实现Comparable接口，所以排序时候会报错
            Arrays.sort(a);
            print("After sort 1: a = " + Arrays.toString(a));
        } catch(ClassCastException e) {
            System.out.println("Array cannot be sorted!");
        }
        for(int i = 0; i < a.length; i++) {
            a[i] = new ComparableBerylliumSphere();
        }
        Collections.shuffle(Arrays.asList(a), r);
        print("Before sort 2: a = " + Arrays.toString(a));
        Arrays.sort(a);
        print("After sort 2: a = " + Arrays.toString(a));
        Collections.shuffle(Arrays.asList(a), r);
        print("Before rev. sort 3: a = " + Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        print("After rev. sort 3: a = " + Arrays.toString(a));
    }
}
