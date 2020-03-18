package array;


/**
 * @packgeName: array
 * @ClassName: E01_ArrayInitialization
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/15-21:01
 * @version: 1.0
 * @since: JDK 1.8
 */
class BerylliumSphere {

    private static long counter;
    private final long id = counter++;
    public String toString() {
        return "Sphere " + id;
    }
}


public class E01_ArrayInitialization {

    static void hide(BerylliumSphere[] spheres) {
        System.out.println("Hiding " + spheres.length + " sphere(s)");
    }

    public static void main(String[] args) {

//        Dynamic aggregate initialization
        hide(new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere()});

//        aggregate initialization
//        hide({new BerylliumSphere(),new BerylliumSphere()});

        BerylliumSphere[] d = {new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()};

        hide(d);

        BerylliumSphere[] a = new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere()};

        hide(a);

    }
}
