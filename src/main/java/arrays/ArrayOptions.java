//: arrays/ArrayOptions.java

// Initialization & re-assignment of arrays.
package arrays;

import java.util.Arrays;

import static net.mindview.util.Print.print;

public class ArrayOptions {

    public static void main(String[] args) {
        // a  b   c   d
        // Arrays of objects:
        BerylliumSphere[] a; // Local uninitialized variable
        BerylliumSphere[] b = new BerylliumSphere[5];

        // The references inside the array are automatically initialized to null:
        //print("a: " + Arrays.toString(a));
        print("b: " + Arrays.toString(b));

        BerylliumSphere[] c = new BerylliumSphere[4];
        for (int i = 0; i < c.length; i++) {
            if (c[i] == null) {   // Can test for null reference
                c[i] = new BerylliumSphere();
            }
        }

//        Class[] clazz;
//        clazz = new Class[]{String.class, Long.class};
//        clazz = {String.class, Long.class};
//        Class[] clazz2 = {String.class, Long.class};;


        // Aggregate initialization:  {}必须在d定义的旁边创建对象
        BerylliumSphere[] d = {new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()};
        System.out.println("d.length = " +d.length);
        //Dynamic aggregate initialization: 在任意地方都可以初始化对象数组
        BerylliumSphere[] d2 = new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()};
        System.out.println("d2.length = " +d2.length);
        //有什么区别???

        //a = {new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()};  error
        // Dynamic aggregate initialization:
        a = new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere(),};

        // (Trailing comma is optional in both cases)
        print("a.length = " + a.length);
        print("b.length = " + b.length);
        print("c.length = " + c.length);
        print("d.length = " + d.length);
        a = d;
        print("a.length = " + a.length);

        // Arrays of primitives:
        int[] e; // Null reference
        int[] f = new int[5];
        // The primitives inside the array are automatically initialized to zero:
        print("f: " + Arrays.toString(f));

        int[] g = new int[4];
        for (int i = 0; i < g.length; i++) {
            g[i] = i * i;
        }

        int[] h = {11, 47, 93};
        // Compile error: variable e not initialized:
        //!print("e.length = " + e.length);
        print("f.length = " + f.length);
        print("g.length = " + g.length);
        print("h.length = " + h.length);
        e = h;
        print("e.length = " + e.length);
        //创建基本类型数组
        e = new int[]{1, 2};
//        e = new int[3]{1,2,3};  error
//        e = {1,2};   error
        print("e.length = " + e.length);
    }
} /* Output:
b: [null, null, null, null, null]
a.length = 2
b.length = 5
c.length = 4
d.length = 3
a.length = 3
f: [0, 0, 0, 0, 0]
f.length = 5
g.length = 4
h.length = 3
e.length = 3
e.length = 2
*///:~
