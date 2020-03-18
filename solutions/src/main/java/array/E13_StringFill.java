package array;

import net.mindview.util.CountingGenerator;

/**
 * @packgeName: array
 * @ClassName: E13_StringFill
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/16-12:52
 * @version: 1.0
 * @since: JDK 1.8
 */
public class E13_StringFill {
    public static void main(String[] args) {
        String s = new CountingGenerator.String(5).next();
        System.out.println(s);
    }
}
