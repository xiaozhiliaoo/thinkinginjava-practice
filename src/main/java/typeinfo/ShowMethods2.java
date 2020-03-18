package typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @packgeName: typeinfo
 * @ClassName: ShowMethods2
 * @copyright: CopyLeft
 * @description:<描述> 练习
 * @author: lili
 * @date: 2017/8/27-16:31
 * @version: 1.0
 * @since: JDK 1.8
 */
public class ShowMethods2 {

    private static Pattern p = Pattern.compile("\\w+\\.");

    private static String usage =
            "usage:\n ShowMethods qualified.class.name\n" +
                    "To show all methods in class or:\n" +
                    "ShowMethods qualified.class.name word\n" +
                    "To search for methods involving 'word'";


    public static void main(String[] args) {

        try {
            Class<?> c = Class.forName("typeinfo.ShowMethods2");
            Method[] methods = c.getMethods();
            Constructor<?>[] constructors = c.getConstructors();
            for (Method method : methods) {
                System.out.println(p.matcher(method.toString()).replaceAll(""));
            }
            for (Constructor<?> constructor : constructors) {
                System.out.println(p.matcher(constructor.toString()).replaceAll(""));
            }

        } catch (ClassNotFoundException e) {
            System.out.println(" No such Class: ");
        }
    }
}
