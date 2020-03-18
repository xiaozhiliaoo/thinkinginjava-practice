package io;//: io/MemoryInput.java

import java.io.*;

public class MemoryInput {

    public static void main(String[] args) throws IOException {

//        StringReader in = new StringReader(BufferedInputFile.read("D:\\MavenSpace\\thinkinjava\\src\\main\\java\\io\\MemoryInput.java"));
        StringReader in = new StringReader("wwwwwwwwwwwww");
        int c;
//可以一个字符一个字符的读取
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
    }
} /* (Execute to see output) *///:~
