package io;//: io/Redirecting.java
// Demonstrates standard I/O redirection.

import java.io.*;

public class Redirecting {
    public static void main(String[] args) throws IOException {

        String inPath = "D:\\MavenSpace\\thinkinjava\\src\\main\\java\\io\\Redirecting.java";
        String outPath = "D:\\MavenSpace\\thinkinjava\\src\\main\\java\\io\\redirecting.txt";
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(inPath));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(outPath)));
        //重定向
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        // System.in 必须包装
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        out.close(); // Remember this!
        System.setOut(console);
    }
} ///:~
