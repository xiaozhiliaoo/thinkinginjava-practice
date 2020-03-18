//: net/mindview/util/OSExecute.java
// Run an operating system command
// and send the output to the console.
package net.mindview.util;

import java.io.*;

public class OSExecute {

    /**
     * 将其他系统的进程输入输出显示在控制台
     * @param command
     */
    public static void command(String command) {

        boolean err = false;
        try {
            //抽象类 JDK1.0       final类  JDK1.5
            Process process = new ProcessBuilder(command.split(" ")).start();
            //带缓存的字符流
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = results.readLine()) != null) {
                System.out.println(s);
            }
            // 获取错误流
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            // Report errors and return nonzero value to calling process if there are problems:
            while ((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true;
            }
        } catch (Exception e) {
            // Compensate for Windows 2000, which throws an exception for the default command line:
            if (!command.startsWith("CMD /C")) {
                //可能会少了cmd
                command("CMD /C " + command);
            } else {
                throw new RuntimeException(e);
            }
        }
        if (err) {
            throw new OSExecuteException("Errors executing " + command);
        }
    }
} ///:~
