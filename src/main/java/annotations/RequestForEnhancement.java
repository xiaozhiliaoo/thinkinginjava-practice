package annotations;

/**
 * @packgeName: annotations
 * @ClassName: RequestForEnhancement
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/10-20:45
 * @version: 1.0
 * @since: JDK 1.8
 */
public @interface RequestForEnhancement {
    int id();
    String synopsis();
    String engineer()  default "[unassigned]";
    String date() default "[unimplements]";
}
