package io;//: io/BufferedInputFile.java

import java.io.*;

public class BufferedInputFile {
    // Throw exceptions to console:
    public static String read(String filename) throws IOException {
        // Reading input by lines:
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

//        文件路径  字符串中被用作转义了
        System.out.print(read("D:\\MavenSpace\\thinkinjava\\src\\main\\java\\io\\BufferedInputFile.java"));
    }
} /* (Execute to see output) *///:~
