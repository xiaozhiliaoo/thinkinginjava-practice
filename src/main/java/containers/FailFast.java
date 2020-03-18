//: containers/FailFast.java

// Demonstrates the "fail-fast" behavior.
package containers;

import java.util.*;


public class FailFast {
    //Hashtable
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();
//        List<String> c = Collections.synchronizedList(new ArrayList<>());
        Iterator<String> it = c.iterator();
        //模拟多线程写法   添加前给了一个元素
        c.add("An object");
        try {
            String s = it.next();
        } catch (ConcurrentModificationException e) {
            System.out.println(e);
        }
    }
} /* Output:
java.util.ConcurrentModificationException
*///:~
