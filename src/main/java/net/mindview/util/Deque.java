//: net/mindview/util/Deque.java
// Creating a Deque from a LinkedList.
package net.mindview.util;

import java.util.*;

//Jdk1.6后Deque已经是接口了。模拟1.5
public class Deque<T> {
    //LinkedList支持
    private LinkedList<T> deque = new LinkedList<T>();

    public void addFirst(T e) {
        deque.addFirst(e);
    }

    public void addLast(T e) {
        deque.addLast(e);
    }

    public T getFirst() {
        return deque.getFirst();
    }

    public T getLast() {
        return deque.getLast();
    }

    public T removeFirst() {
        return deque.removeFirst();
    }

    public T removeLast() {
        return deque.removeLast();
    }

    public int size() {
        return deque.size();
    }

    public String toString() {
        return deque.toString();
    }
    // And other methods as necessary...
} ///:~
