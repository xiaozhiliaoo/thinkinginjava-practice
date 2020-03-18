package array;

import net.mindview.util.Generated;
import net.mindview.util.Generator;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @packgeName: array
 * @ClassName: E17_BigDecimalGenerator
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/16-16:01
 * @version: 1.0
 * @since: JDK 1.8
 */

class BigDecimalGenerator implements Generator<BigDecimal>{

    private BigDecimal value = new BigDecimal(0);
    private BigDecimal step;

    public BigDecimalGenerator(BigDecimal step) {
        this.step = step;
    }

    @Override
    public BigDecimal next() {
        BigDecimal oldValue = value;
        value = oldValue.add(step);
        return oldValue;
    }
}


public class E17_BigDecimalGenerator {


    public static void main(String[] args) {
        BigDecimal[] a = { new BigDecimal(9),
                new BigDecimal(8),
                new BigDecimal(7), new BigDecimal(6) };
        a = Generated.array(a, new BigDecimalGenerator(
                new BigDecimal("0.1")));
        System.out.println(Arrays.toString(a));
        BigDecimal[] b = Generated.array(BigDecimal.class,
                new BigDecimalGenerator(new BigDecimal("0.2")), 15);
        System.out.println(Arrays.toString(b));
    }


}


