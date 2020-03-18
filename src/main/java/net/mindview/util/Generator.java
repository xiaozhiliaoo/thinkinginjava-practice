//: net/mindview/util/Generator.java
// A generic interface.
package net.mindview.util;


//生成器接口   类似于迭代器   T 生成元素类型
public interface Generator<T> {
    T next();
} ///:~
