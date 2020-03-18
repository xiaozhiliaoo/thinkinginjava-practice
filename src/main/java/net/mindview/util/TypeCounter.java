//: net/mindview/util/TypeCounter.java
// Counts instances of a type family.
package net.mindview.util;

import java.util.*;

public class TypeCounter extends HashMap<Class<?>, Integer> {

    private Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object obj) {
        //获取类信息
        Class<?> type = obj.getClass();
        //非从属关系
        if (!baseType.isAssignableFrom(type)) {
            throw new RuntimeException(obj + " incorrect type: " + type + ", should be type or subtype of " + baseType);
        }
        //递归计算
        countClass(type);
    }

    //递归方法
    private void countClass(Class<?> type) {
        //通过类型获取数量
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        //查找父类
        Class<?> superClass = type.getSuperclass();
        //有父类且有直接基类
        if (superClass != null && baseType.isAssignableFrom(superClass)) {
            countClass(superClass);
        }
    }

    public String toString() {
        /**
         * {Mouse=2, Dog=6, Manx=7, EgyptianMau=2,
         * Rodent=5, Pug=3, Mutt=3, Cymric=5, Cat=9, Hamster=1, Pet=20, Rat=2}
         */
        StringBuilder result = new StringBuilder("{");
        for (Entry<Class<?>, Integer> pair : entrySet()) {
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue());
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("}");
        return result.toString();
    }
} ///:~
