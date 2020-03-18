//: net/mindview/util/ProcessFiles.java
package net.mindview.util;

import java.io.*;

public class ProcessFiles {

    //策略接口实现了内部接口，封装
    public interface Strategy {
        void process(File file);
    }

    //    策略接口
    private Strategy strategy;
    //    文件扩展名
    private String ext;


    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0) {
                processDirectoryTree(new File("."));
            } else {
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory()) {
                        processDirectoryTree(fileArg);
                    } else {
                        // Allow user to leave off extension:
                        if (!arg.endsWith("." + ext)) {
                            arg += "." + ext;
                        }
//                        策略具体处理方法  规范路径
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //    处理目录树
    public void processDirectoryTree(File root) throws IOException {
//        绝对路径  指定扩展名
        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
            strategy.process(file.getCanonicalFile());
        }
    }

    // Demonstration of how to use it:
    public static void main(String[] args) {
//        匿名策略对象
        new ProcessFiles(new Strategy() {
            public void process(File file) {
//                处理方法：打印文件
                System.out.println(file);
            }
        }, "java").start(args);
//        扩展名 .java
    }
} /* (Execute to see output) *///:~
