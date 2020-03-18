//: io/TestEOF.java
// Testing for end of file while reading a byte at a time.
package io;

import java.io.*;

public class TestEOF {
    public static void main(String[] args)
            throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("D:\\MavenSpace\\thinkinjava\\src\\main\\java\\io\\TestEOF.java")));
        while (in.available() != 0) {
            System.out.print((char) in.readByte());
        }
    }
} /* (Execute to see output) *///:~
