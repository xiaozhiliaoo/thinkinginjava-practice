package exceptions;//: exceptions/LoggingExceptions2.java
// Logging caught exceptions.

import java.util.logging.*;
import java.io.*;

public class LoggingExceptions2 {

    //方法名和类名一样
    private static Logger logger = Logger.getLogger("LoggingExceptions2");

    //异常写在公共方法里面，LoggingException写在了异常本身里面，集中处理异常情况。
    static void logException(Exception e) {

        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());

        //Write in File
    }


    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            //统一处理，统一记录到文件里面
            logException(e);
        }
    }
} /* Output: (90% match)
Aug 30, 2005 4:07:54 PM LoggingExceptions2 logException
SEVERE: java.lang.NullPointerException
        at LoggingExceptions2.main(LoggingExceptions2.java:16)
*///:~
