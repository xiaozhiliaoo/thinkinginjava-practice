package array;

import net.mindview.util.ConvertTo;
import net.mindview.util.CountingGenerator;
import net.mindview.util.Generated;

import java.util.Arrays;

/**
 * @packgeName: array
 * @ClassName: E12_GeneratedDArray
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/16-12:49
 * @version: 1.0
 * @since: JDK 1.8
 */
public class E12_GeneratedDArray {
    public static void main(String[] args) {
        double[] d = ConvertTo.primitive(Generated.array(Double.class,new CountingGenerator.Double(),15));
        Arrays.toString(d);
    }
}
