package io;//: io/BasicFileOutput.java

import java.io.*;

public class BasicFileOutput {

    static String file = "D:\\MavenSpace\\thinkinjava\\src\\main\\java\\io\\BasicFileOutput.txt";

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new StringReader(
                BufferedInputFile.read(
                        "D:\\MavenSpace\\thinkinjava\\src\\main\\java\\io\\BasicFileOutput.java")));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        //行数
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            //每读取一行  就加一个行号
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
} /* (Execute to see output) *///:~
