//: io/OSExecuteDemo.java
// Demonstrates standard I/O redirection.
package io;

import net.mindview.util.OSExecute;

public class OSExecuteDemo {
    public static void main(String[] args) {

//        OSExecute.command("javap OSExecuteDemo");
          OSExecute.command("dir");
//        OSExecute.command("mysql");
    }
}

/* Output:
Compiled from "OSExecuteDemo.java"
public class OSExecuteDemo extends java.lang.Object{
    public OSExecuteDemo();
    public static void main(java.lang.String[]);
}
*///:~
