package io;//: io/Logon.java
// Demonstrates the "transient" keyword.

import java.util.concurrent.*;
import java.io.*;
import java.util.*;

import static net.mindview.util.Print.*;

public class Logon implements Serializable {

    private Date date = new Date();
    private String username;
    /**
     * 密码属于敏感字段，可以不被序列化和反序列化
     */
    private transient String password;

    public Logon(String name, String pwd) {
        username = name;
        password = pwd;
    }

    public String toString() {
        return "logon info: \n   username: " + username +
                "\n   date: " + date + "\n   password: " + password;
    }

    public static void main(String[] args) throws Exception {
        String path = "D:\\MavenSpace\\thinkinjava\\src\\main\\java\\io\\";
        Logon a = new Logon("Hulk", "myLittlePony");
        //此时候会被保存
        print("logon a = " + a);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(path+"Logon.out"));
        o.writeObject(a);
        o.close();
        TimeUnit.SECONDS.sleep(5); // Delay
        // Now get them back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path+"Logon.out"));
        print("Recovering object at " + new Date());
        a = (Logon) in.readObject();

        print("logon a = " + a);
        System.out.println("-----------------------------------------");
        print("a.date: "+a.date);
    }
} /* Output: (Sample)
logon a = logon info:
   username: Hulk
   date: Sat Nov 19 15:03:26 MST 2005
   password: myLittlePony
Recovering object at Sat Nov 19 15:03:28 MST 2005
logon a = logon info:
   username: Hulk
   date: Sat Nov 19 15:03:26 MST 2005
   password: null
*///:~
