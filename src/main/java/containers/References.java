//: containers/References.java
// Demonstrates Reference objects
package containers;
import java.lang.ref.*;
import java.util.*;

class VeryBig {

    //-XX:+HeapDumpOnOutOfMemoryError   java.lang.OutOfMemoryError: Java heap space
    // private static final int SIZE = 1000000000;
    private static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;
    public VeryBig(String id) { ident = id; }
    public String toString() { return ident; }
    protected void finalize() {
        System.out.println("Finalizing " + ident);
    }
}

public class References {

    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();

    public static void checkQueue() {

        Reference<? extends VeryBig> inq = rq.poll();
        if(inq != null) {
            System.out.println("In queue: " + inq.get());
        }
    }

    public static void main(String[] args) {
        int size = 10;
        // Or, choose size via the command line:
        if(args.length > 0) {
            size = new Integer(args[0]);
        }

        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<SoftReference<VeryBig>>();

        for(int i = 0; i < size; i++) {
            sa.add(new SoftReference<VeryBig>(new VeryBig("Soft " + i), rq));
            System.out.println("Just created: " + sa.getLast());
            checkQueue();
        }

        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<WeakReference<VeryBig>>();

        for(int i = 0; i < size; i++) {
            wa.add(new WeakReference<VeryBig>(new VeryBig("Weak " + i), rq));
            System.out.println("Just created: " + wa.getLast());
            checkQueue();
        }

        SoftReference<VeryBig> s = new SoftReference<VeryBig>(new VeryBig("Soft"));
        WeakReference<VeryBig> w = new WeakReference<VeryBig>(new VeryBig("Weak"));
        //垃圾回收
        System.out.println("-----------------System.gc()--------------------------");
        //只有Weak被回收了...而SoftReference依然存在
        System.gc();

        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<PhantomReference<VeryBig>>();
        for(int i = 0; i < size; i++) {
            pa.add(new PhantomReference<VeryBig>(new VeryBig("Phantom " + i), rq));
            System.out.println("Just created: " + pa.getLast());
            checkQueue();
        }
        //System.gc();
        //PhantomReference被回收

    }
} /* (Execute to see output) *///:~
