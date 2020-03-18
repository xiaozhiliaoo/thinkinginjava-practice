package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @packgeName: annotations
 * @ClassName: Test
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/10-20:49
 * @version: 1.0
 * @since: JDK 1.8
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestFOO {
}
