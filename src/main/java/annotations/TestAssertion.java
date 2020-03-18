package annotations;

/**
 * @packgeName: annotations
 * @ClassName: TestAssertion
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/12-20:44
 * @version: 1.0
 * @since: JDK 1.8
 */
public class TestAssertion {
    public static void main(String[] args) {
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true); // Enable asserts
        assert 1 == 3;
    }
}
