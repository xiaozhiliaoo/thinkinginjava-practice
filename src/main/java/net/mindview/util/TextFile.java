//: net/mindview/util/TextFile.java
// Static functions for reading and writing text files as
// a single string, and treating a file as an ArrayList.
package net.mindview.util;

import java.io.*;
import java.util.*;


/**
 * 工具类
 */
public class TextFile extends ArrayList<String> {

    // Read a file as a single string:
    public static String read(String fileName) {

        StringBuilder sb = new StringBuilder();

        try {
            //装饰器模式  FileReader没有方法可以处理，或者方法不方便处理
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));

            try {
                //动态字符串
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    //添加换行符
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }


    /**
     * Write a single file in one method call:
     * @param fileName
     * @param text
     */
    public static void write(String fileName, String text) {
        try {

            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());

            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    /**
     * 创建实例对象来使用 Read a file, split by any regular expression:
     * @param fileName
     * @param splitter
     */
    public TextFile(String fileName, String splitter) {

        super(Arrays.asList(read(fileName).split(splitter)));
        // Regular expression split() often leaves an empty
        // String at the first position:
        if (get(0).equals("")) {
            remove(0);
        }
    }

    // Normally read by lines: 默认以换行符划分
    public TextFile(String fileName) {
        //this调用构造器
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                //传入实例自身  this
                for (String item : this) {
                    //换行写入
                    out.println(item);
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Simple test:
    public static void main(String[] args) {

        String path = "D:\\MavenSpace\\thinkinjava\\src\\main\\java\\net\\mindview\\util\\";
        //直接使用
        String file = TextFile.read(path+"TextFile.java");

        TextFile.write(path+"testfile.txt", file);

        //实例化使用
        TextFile text = new TextFile(path+"testfile.txt");
        text.write(path+"testfile2.txt");
        // Break into unique sorted list of words:
        TreeSet<String> words = new TreeSet<String>(new TextFile(path+"TextFile.java", "\\W+"));
        // Display the capitalized words:
        //单词排序  天然用TreeSet ，找小于是a的子集，所以保留了开头有大写的
        System.out.println(words.headSet("a"));
    }
} 
/* Output:
[0, ArrayList, Arrays, Break, BufferedReader, BufferedWriter, Clean, Display, File, FileReader, FileWriter, IOException, Normally, Output, PrintWriter, Read, Regular, RuntimeException, Simple, Static, String, StringBuilder, System, TextFile, Tools, TreeSet, W, Write]
*///:~
