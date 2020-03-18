//: object/ShowProperties.java
package object;
//P31
public class ShowProperties {
  public static void main(String[] args) {
	  //jvm相关的路劲
    System.getProperties().list(System.out);
    System.out.println(System.getProperty("user.name"));
	  //环境变量里面的路径
    System.out.println(System.getProperty("java.library.path"));
  }
} ///:~
