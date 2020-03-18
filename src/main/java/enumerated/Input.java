//: enumerated/Input.java
package enumerated;
import java.util.*;

public enum Input {
  //币种 5美分，10美分，25美分，1美元，
  NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
  // 产品 牙膏(200) 薯片(75)  苏打水(100) 肥皂(50)
  TOOTHPASTE(200), CHIPS (75), SODA(100), SOAP(50),
  // 终止交易
  ABORT_TRANSACTION {
    public int amount() { // Disallow
      throw new RuntimeException("ABORT.amount()");
    }
  },
  // 结束
  STOP { // This must be the last instance.
    public int amount() { // Disallow
      throw new RuntimeException("SHUT_DOWN.amount()");
    }
  };

  int value; // In cents 美分

  Input(int value) { this.value = value; }
  Input() {}
  int amount() { return value; }; // In cents
  static Random rand = new Random(47);
  public static Input randomSelection() {
    // Don't include STOP:
    return values()[rand.nextInt(values().length - 1)];
  }
} ///:~
