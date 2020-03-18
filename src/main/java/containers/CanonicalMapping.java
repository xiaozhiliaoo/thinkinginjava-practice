//: containers/CanonicalMapping.java
// Demonstrates WeakHashMap.
package containers;

import java.util.*;

class Element {

    private String ident;

    public Element(String id) {
        ident = id;
    }

    public String toString() {
        return ident;
    }

    public int hashCode() {
        return ident.hashCode();
    }

    public boolean equals(Object r) {

        return r instanceof Element &&
                ident.equals(((Element) r).ident);
    }

    protected void finalize() {
        System.out.println("Finalizing " + getClass().getSimpleName() + " " + ident);
    }
}

class Key extends Element {
    public Key(String id) {
        super(id);
    }
}

class Value extends Element {
    public Value(String id) {
        super(id);
    }
}

// 规范映射
public class CanonicalMapping {
    public static void main(String[] args) {

        int size = 1000;
        // Or, choose size via the command line:
        if (args.length > 0) {
            size = new Integer(args[0]);
        }
        //1000个key对象数组
        Key[] keys = new Key[size];

        WeakHashMap<Key, Value> map = new WeakHashMap<Key, Value>();

        for (int i = 0; i < size; i++) {

            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if (i % 3 == 0) {
                keys[i] = k; // Save as "real" references   不会被清理  放入1/3 不会被回收
                //keys[i]被普通引用所引用
            }
            //放入不能被3整除的  存在weakhashmap中
            map.put(k, v);
        }
        //回收的肯定是不能整除3的  并非运行就会执行gc  所以不会很多数据
        System.gc();
    }
} /* (Execute to see output) *///:~
