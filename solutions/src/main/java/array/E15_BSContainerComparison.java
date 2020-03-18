package array;

import net.mindview.util.Generated;
import net.mindview.util.Generator;

import java.util.Arrays;
import java.util.List;

/**
 * @packgeName: array
 * @ClassName: ContainerComparison
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/16-13:35
 * @version: 1.0
 * @since: JDK 1.8
 */
class BSGenerator implements Generator<BerylliumSphere>{

    @Override
    public BerylliumSphere next() {
        return new BerylliumSphere();
    }
}

public class E15_BSContainerComparison {
    public static void main(String[] args) {
        BSGenerator generator = new BSGenerator();
        BerylliumSphere[] spheres = Generated.array(BerylliumSphere.class, generator,5);
        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);

        List<BerylliumSphere> sphereList = Arrays.asList(
                Generated.array(BerylliumSphere.class, generator, 5));
        System.out.println(sphereList);
        System.out.println(sphereList.get(4));

        int [] ints = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(ints));

        List<Integer> integers = Arrays.asList(1,2,3,4,5,6);
        System.out.println(integers);

    }
}
