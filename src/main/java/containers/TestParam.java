//: containers/TestParam.java
// A "data transfer object."   do
package containers;

public class TestParam {
    //测试次数
    public final int size;
    // 循环次数
    public final int loops;

    public TestParam(int size, int loops) {
        this.size = size;
        this.loops = loops;
    }

    // Create an array of TestParam from a varargs sequence:
    // 10, 5000, 100, 5000, 1000, 1000, 10000, 200
    //TestParam(10, 5000)   TestParam(100, 5000)   TestParam(1000, 1000)  TestParam(10000, 200)
    public static TestParam[] array(int... values) {
        int size = values.length / 2;
        TestParam[] result = new TestParam[size];
        int n = 0;
        for (int i = 0; i < size; i++) {
            result[i] = new TestParam(values[n++], values[n++]);
        }
        return result;
    }

    // Convert a String array to a TestParam array:
    public static TestParam[] array(String[] values) {
        int[] vals = new int[values.length];
        for (int i = 0; i < vals.length; i++) {
            vals[i] = Integer.decode(values[i]);
        }
        return array(vals);
    }
} ///:~
