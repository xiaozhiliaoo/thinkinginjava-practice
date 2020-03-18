package io;//: io/FileOutputShortcut.java

import java.io.*;

public class FileOutputShortcut {
    static String file = "D:\\MavenSpace\\thinkinjava\\src\\main\\java\\io\\FileOutputShortcut.txt";

    public static void main(String[] args)
            throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("D:\\MavenSpace\\thinkinjava\\src\\main\\java\\io\\FileOutputShortcut.java")));
        // Here's the shortcut:
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        in.close();
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
} /* (Execute to see output) *///:~
