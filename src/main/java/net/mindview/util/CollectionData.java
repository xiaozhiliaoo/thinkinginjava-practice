//: net/mindview/util/CollectionData.java
// A Collection filled with data using a generator object.
package net.mindview.util;
import java.util.*;

public class CollectionData<T> extends ArrayList<T> {

  //Construtors

  /**
   *
   * @param gen   生成器
   * @param quantity  生成元素数量
   */
    public CollectionData(Generator<T> gen, int quantity) {
        for(int i = 0; i < quantity; i++){
            add(gen.next());
        }
    }

  // A generic convenience method:  方便的方法
  public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
      return new CollectionData<T>(gen, quantity);
  }
} ///:~
