package exceptions;//: exceptions/LoggingExceptions.java
// An exception that reports through a Logger.

import java.util.logging.*;
import java.io.*;

//用日志记录异常
class LoggingException extends Exception {

    private static Logger logger = Logger.getLogger("LoggingException");

    public LoggingException() {
        StringWriter trace = new StringWriter();
        //Exception的方法  trace包装一下
        printStackTrace(new PrintWriter(trace));
        //Log a SEVERE message.
        logger.severe(trace.toString());
    }

}

public class LoggingExceptions {

    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            //错误输出流  会记录时间的
            System.err.println("Caught " + e);
        }
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
//            Logger.getLogger(LoggingException.class.getName()).log(Level.SEVERE, null , e);
        }
    }
} /* Output: (85% match)
Aug 30, 2005 4:02:31 PM LoggingException <init>
SEVERE: LoggingException
        at LoggingExceptions.main(LoggingExceptions.java:19)

Caught LoggingException
Aug 30, 2005 4:02:31 PM LoggingException <init>
SEVERE: LoggingException
        at LoggingExceptions.main(LoggingExceptions.java:24)

Caught LoggingException
*///:~
