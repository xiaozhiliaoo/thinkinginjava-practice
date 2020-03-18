package containers;//: containers/Utilities.java
// Simple demonstrations of the Collections utilities.

import java.util.*;

import static net.mindview.util.Print.*;

public class Utilities {

    //从数组返回List视图  使用Arrays生成List比直接add(e)要方便
    static List<String> list = Arrays.asList("one Two three Four five six one".split(" "));

    public static void main(String[] args) {

        print(list);
        //两个集合是否有相交元素
        print("'list' disjoint (Four)?: " + Collections.disjoint(list, Collections.singletonList("Four")));
        //查找最大值
        print("max: " + Collections.max(list));
        //查找最小值
        print("min: " + Collections.min(list));
        //忽略大小写求最大值
        print("max w/ comparator: " + Collections.max(list, String.CASE_INSENSITIVE_ORDER));
        //忽略大小写求最小值
        print("min w/ comparator: " + Collections.min(list, String.CASE_INSENSITIVE_ORDER));
        // 子项
        List<String> sublist = Arrays.asList("Four five six".split(" "));
        //检查子项目，局部
        print("indexOfSubList: " + Collections.indexOfSubList(list, sublist));
        //从后往前
        print("lastIndexOfSubList: " + Collections.lastIndexOfSubList(list, sublist));
        //替换list
        Collections.replaceAll(list, "one", "Yo");
        print("replaceAll: " + list);
        //反转list
        Collections.reverse(list);
        print("reverse: " + list);
        // 元素向后移动三个位置，后面的移到前面来
        Collections.rotate(list, 3);
        print("rotate: " + list);
        // 使用Arrays生成list比一个一个add快的多
        List<String> source = Arrays.asList("in the matrix".split(" "));
        Collections.copy(list, source);//dest  src   没指定位置就替换前三个
        print("copy: " + list);
        //交换顺序  第一个和最后一个交换
        Collections.swap(list, 0, list.size() - 1);
        print("swap: " + list);
        //打乱数组顺序  传入随机数对象
        Collections.shuffle(list, new Random(47));
        print("shuffled: " + list);
        // pop替换所有的元素
        Collections.fill(list, "pop");
        print("fill: " + list);
        // 查看某个元素出现的频率
        print("frequency of 'pop': " + Collections.frequency(list, "pop"));
        // 填充三个snap的list
        List<String> dups = Collections.nCopies(3, "snap");
        print("dups: " + dups);
        //没有相交的元素 返回true
        print("'list' disjoint 'dups'?: " + Collections.disjoint(list, dups));
        // Getting an old-style Enumeration:
        Enumeration<String> e = Collections.enumeration(dups);
        // 对旧的api进行升级
        Vector<String> v = new Vector<String>();
        while (e.hasMoreElements()) {
            v.addElement(e.nextElement());
        }
        // Converting an old-style Vector
        // to a List via an Enumeration:
        ArrayList<String> arrayList = Collections.list(v.elements());
        print("arrayList: " + arrayList);
    }
} /* Output:
[one, Two, three, Four, five, six, one]
'list' disjoint (Four)?: false
max: three
min: Four
max w/ comparator: Two
min w/ comparator: five
indexOfSubList: 3
lastIndexOfSubList: 3
replaceAll: [Yo, Two, three, Four, five, six, Yo]
reverse: [Yo, six, five, Four, three, Two, Yo]
rotate: [three, Two, Yo, Yo, six, five, Four]
copy: [in, the, matrix, Yo, six, five, Four]
swap: [Four, the, matrix, Yo, six, five, in]
shuffled: [six, matrix, the, Four, Yo, five, in]
fill: [pop, pop, pop, pop, pop, pop, pop]
frequency of 'pop': 7
dups: [snap, snap, snap]
'list' disjoint 'dups'?: true
arrayList: [snap, snap, snap]
*///:~
