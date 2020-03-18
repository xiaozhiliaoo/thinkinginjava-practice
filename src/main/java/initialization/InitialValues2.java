//: initialization/InitialValues2.java
// Providing explicit initial values.
package initialization;
//P93
public class InitialValues2 {
  boolean bool = true;
  char ch = 'x';
  byte b = 47;
  short s = 0xff;
  int i = 999;
  long lng = 1;
  float f = 3.14f;
  double d = 3.14159;

    public InitialValues2(boolean bool) {
        this.bool = bool;
    }

    public static void main(String[] args) {
        //指定初始值优于构造方法执行
        InitialValues2 i = new InitialValues2(false);
    }
} ///:~
