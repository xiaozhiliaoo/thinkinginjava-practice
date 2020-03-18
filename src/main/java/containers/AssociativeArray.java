//: containers/AssociativeArray.java

// Associates keys with values.
package containers;

import static net.mindview.util.Print.*;

//仿Map
public class AssociativeArray<K, V> {

    private Object[][] pairs; //存储键值的二维数组对象
    private int index;  //操作二位数组索引

    public AssociativeArray(int length) {
        //只能存两个元素
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if (index >= pairs.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        //后置++  索引同步增加
        pairs[index++] = new Object[]{key, value};
    }

    //效率最差的方式查找值，循环方式。固定尺寸不灵活。
    @SuppressWarnings("unchecked")
    public V get(K key) {
        //循环查找数据
        for (int i = 0; i < index; i++) {
            if (key.equals(pairs[i][0])) {  //key
                return (V) pairs[i][1];    //value
            }
        }
        return null; // Did not find key
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if (i < index - 1) {
                result.append("\n");  //增加换行
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        AssociativeArray<String, String> map = new AssociativeArray<String, String>(6);
        map.put("sky", "blue"); //天空 蓝色
        map.put("grass", "green"); //草  绿色
        map.put("ocean", "dancing");// 海洋 跳舞
        map.put("tree", "tall");//树 高大
        map.put("earth", "brown");//泥土  褐色
        map.put("sun", "warm");//太阳 温暖
        try {
            //不让程序中断
            map.put("extra", "object"); // Past the end
        } catch (ArrayIndexOutOfBoundsException e) {
            print("Too many objects!");
        }
        print(map);
        print("map.get(\"ocean\")="+map.get("ocean"));
    }
} /* Output:
Too many objects!
sky : blue
grass : green
ocean : dancing
tree : tall
earth : brown
sun : warm
dancing
*///:~
