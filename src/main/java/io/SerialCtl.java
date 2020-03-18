package io;//: io/SerialCtl.java
// Controlling serialization by adding your own
// writeObject() and readObject() methods.

/**
 * Externalizable 的替代解决方案
 */

import java.io.*;

public class SerialCtl implements Serializable {

    /**
     * 可被序列化，自动化序列保存的
     */
    private String a;
    /**
     * 不会被序列化
     */
    private transient String b;


    public SerialCtl(String aa, String bb) {
        a = "Not Transient: " + aa;
        b = "Transient: " + bb;
    }

    public String toString() {
        return a + "\n" + b;
    }

    /**
     * 替代可外部化接口
     * @param stream
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream stream) throws IOException {
        //默认写入对象
        stream.defaultWriteObject();
        //强制写入不会被自动序列化的对象  参考Externalizable
        stream.writeObject(b);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        //默认读取对象
        stream.defaultReadObject();
        //手工保存
        b = (String) stream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialCtl sc = new SerialCtl("Test1", "Test2");
        System.out.println("Before:\n" + sc);
        //序列化对象存在内存中
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(buf);
        o.writeObject(sc);
        // Now get it back:
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
        SerialCtl sc2 = (SerialCtl) in.readObject();
        System.out.println("After:\n" + sc2);
    }
} /* Output:
Before:
Not Transient: Test1
Transient: Test2
After:
Not Transient: Test1
Transient: Test2
*///:~
