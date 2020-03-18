package array;

import java.lang.reflect.Field;
import java.util.Arrays;

import static net.mindview.util.Print.print;

/**
 * @packgeName: array
 * @ClassName: E18_ArrayCopy
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/16-20:14
 * @version: 1.0
 * @since: JDK 1.8
 */
public class E18_ArrayCopy {

    static void setID(BerylliumSphere bs, long value) {
        try {
            Field field = BerylliumSphere.class.getDeclaredField("id");
            field.setAccessible(true);
            field.setLong(bs, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BerylliumSphere[] a = new BerylliumSphere[4];
        Arrays.fill(a, new BerylliumSphere());
        BerylliumSphere[] b = new BerylliumSphere[4];
        print("a = " + Arrays.toString(a));
        print("b = " + Arrays.toString(b));

        System.arraycopy(a, 0, b, 0, b.length);
        print("b = " + Arrays.toString(b));
// Changing a reference in 'a' will not impact 'b'.
        a[1] = a[3] = new BerylliumSphere();
        print("a = " + Arrays.toString(a));
        print("b = " + Arrays.toString(b));
// Changing an object's state will impact 'b', as well.
        setID(a[0], -1L);
        print("a = " + Arrays.toString(a));
        print("b = " + Arrays.toString(b));

    }
}
