//: object/ShowProperties.java
package object;
//P31
public class ShowProperties {
  public static void main(String[] args) {
	  //jvm��ص�·��
    System.getProperties().list(System.out);
    System.out.println(System.getProperty("user.name"));
	  //�������������·��
    System.out.println(System.getProperty("java.library.path"));
  }
} ///:~
