package io;//: io/Blips.java
// Simple use of Externalizable & a pitfall.

import java.io.*;

import static net.mindview.util.Print.*;

class Blip1 implements Externalizable {
    /**
     * 公共构造方法
     */
    public Blip1() {
        print("Blip1 Constructor");
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        print("Blip1.writeExternal");
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {
    /**
     * 非公共  默认包
     */
    Blip2() {
        print("Blip2 Constructor");
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        print("Blip2.writeExternal");
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("Blip2.readExternal");
    }
}

public class Blips {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "D:\\MavenSpace\\thinkinjava\\src\\main\\java\\io\\";
        print("Constructing objects:");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(path+"Blips.out"));
        print("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();
        System.out.println("-------------------------------");
        // Now get them back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path+"Blips.out"));
        print("Recovering b1:");
        b1 = (Blip1) in.readObject();
        // OOPS! Throws an exception:

        print("Recovering b2:");
        b2 = (Blip2)in.readObject();
    }
} /* Output:
Constructing objects:
Blip1 Constructor
Blip2 Constructor
Saving objects:
Blip1.writeExternal
Blip2.writeExternal
Recovering b1:
Blip1 Constructor
Blip1.readExternal
*///:~
