package xml;

import nu.xom.*;

import java.util.ArrayList;

/**
 * @packgeName: xml
 * @ClassName: People
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/10-16:46
 * @version: 1.0
 * @since: JDK 1.8
 */
public class People  extends ArrayList<Person>{

    public People(String fileName) throws Exception{
        Document doc = new Builder().build(fileName);
        Elements elements = doc.getRootElement().getChildElements();
        for (int i = 0; i < elements.size(); i++) {
            add(new Person(elements.get(i)));
        }
    }

    public static void main(String[] args) throws Exception {
        People p = new People("D:\\MavenSpace\\thinkinjava\\src\\main\\java\\xml\\People.xml");
        System.out.println(p);
    }
}
