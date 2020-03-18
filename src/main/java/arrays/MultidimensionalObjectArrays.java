//: arrays/MultidimensionalObjectArrays.java
package arrays;

import java.util.*;


public class MultidimensionalObjectArrays {
    public static void main(String[] args) {

        BerylliumSphere[][] spheres = {
                {
                    new BerylliumSphere(),
                    new BerylliumSphere()
                },
                {
                    new BerylliumSphere(),
                    new BerylliumSphere(),
                    new BerylliumSphere(),
                    new BerylliumSphere()
                },
                {
                    new BerylliumSphere(),
                    new BerylliumSphere(),
                    new BerylliumSphere(),
                    new BerylliumSphere(),
                    new BerylliumSphere(),
                    new BerylliumSphere(),
                    new BerylliumSphere(),
                    new BerylliumSphere()
                },
        };
        System.out.println(spheres);
        System.out.println(Arrays.toString(spheres));
        System.out.println(Arrays.deepToString(spheres));
    }
} /* Output:
[[Larrays.BerylliumSphere;@6f75e721
[[Larrays.BerylliumSphere;@69222c14, [Larrays.BerylliumSphere;@606d8acf, [Larrays.BerylliumSphere;@782830e]
[[Sphere 0, Sphere 1], [Sphere 2, Sphere 3, Sphere 4, Sphere 5], [Sphere 6, Sphere 7, Sphere 8, Sphere 9, Sphere 10, Sphere 11, Sphere 12, Sphere 13]]*///:~
