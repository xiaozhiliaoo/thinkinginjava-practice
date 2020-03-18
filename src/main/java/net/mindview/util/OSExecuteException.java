//: net/mindview/util/OSExecuteException.java
package net.mindview.util;

/**
 * 操作系统进程自身抛出的异常
 */
public class OSExecuteException extends RuntimeException {
    public OSExecuteException(String why) {
        super(why);
    }
} ///:~
