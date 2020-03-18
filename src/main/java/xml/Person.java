package xml;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @packgeName: xml
 * @ClassName: Person
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/10-16:43
 * @version: 1.0
 * @since: JDK 1.8
 */
public class Person {
    private String first;
    private String last;

    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public Element getXML(){
        Element person = new Element("person");
        Element firstName = new Element("first");
        Element lastName = new Element("last");
        firstName.appendChild(first);
        lastName.appendChild(last);
        person.appendChild(firstName);
        person.appendChild(lastName);
        return person;
    }

    public Person(Element person){
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
    }

    @Override
    public String toString() {
        return first+"  "+last;
    }

    public static void format(OutputStream os, Document doc) throws Exception{
        Serializer serializer = new Serializer(os, "ISo-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }


    public static void main(String[] args) throws Exception {
        String path = "D:\\MavenSpace\\thinkinjava\\src\\main\\java\\xml\\";
        List<Person> people = Arrays.asList(new Person("li","li"), new Person("zhang","chi"),new Person("aaa","ddd"));
        System.out.println(people);
        Element root = new Element("people");
        for (Person p : people) {
            root.appendChild(p.getXML());
        }
        Document doc = new Document(root);
        format(System.out, doc);
        format(new BufferedOutputStream(new FileOutputStream(path+"People.xml")),doc);
    }
}
