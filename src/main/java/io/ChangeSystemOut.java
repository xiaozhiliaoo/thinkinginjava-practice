package io;//: io/ChangeSystemOut.java
// Turn System.out into a PrintWriter.

import java.io.*;

public class ChangeSystemOut {
    public static void main(String[] args) {
        //开启自动清空功能
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello, world");

    }

} /* Output:
Hello, world
*///:~
