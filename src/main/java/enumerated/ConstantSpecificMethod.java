package enumerated;//: enumerated/ConstantSpecificMethod.java
import java.util.*;
import java.text.*;

public enum ConstantSpecificMethod {

  DATE_TIME {
    String getInfo() {
      return DateFormat.getDateInstance().format(new Date());
    }
  },

  CLASSPATH {
    String getInfo() {
      return System.getenv("CLASSPATH");
    }
  },

  VERSION {
    String getInfo() {
      return System.getProperty("java.version");
    }
  };

  abstract String getInfo();

  public static void main(String[] args) {
    for(ConstantSpecificMethod csm : values())
      System.out.println(csm.getInfo());
  }
} /* (Execute to see output) *///:~
/*
2017-8-5
null
1.8.0_111*/
