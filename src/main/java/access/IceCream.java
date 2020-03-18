//: access/IceCream.java
// Demonstrates "private" keyword.
package access;

//Ê¥´ú±ùä¿ÁÜ
class Sundae {
  private Sundae() {}
  
  static Sundae makeASundae() {
    return new Sundae();
  }
  
  
}

public class IceCream {
  public static void main(String[] args) {
  //Sundae x = new Sundae();
    Sundae x = Sundae.makeASundae();
  }
} ///:~
