//: containers/RandomBounds.java
// Does Math.random() produce 0.0 and 1.0?
// {RunByHand}
package containers;
import static net.mindview.util.Print.*;

public class RandomBounds {
  static void usage() {
    print("Usage:");
    print("\tRandomBounds lower");
    print("\tRandomBounds upper");
    System.exit(1);
  }
  
  public static void main(String[] args) {
	//输入一个参数
    if(args.length != 1) {
    	usage();
    }
    if(args[0].equals("lower")) {
      while(Math.random() != 0.0); // Keep trying
      print("Produced 0.0!");
    } else if(args[0].equals("upper")) {
      while(Math.random() != 1.0)
        ; // Keep trying
      print("Produced 1.0!");
    }else{
      usage();
    }
  }
} ///:~
