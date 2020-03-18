package exceptions;//: exceptions/DynamicFields.java
// A Class that dynamically adds fields to itself.
// Demonstrates exception chaining.

import static net.mindview.util.Print.*;

class DynamicFieldsException extends Exception {
}

public class DynamicFields {
    //二维数组
    private Object[][] fields;

    //初始化大小  两列

    /**
     * 1  1
     * 2  2
     * 3  3
     * 4  4
     * 5  5
     * @param initialSize
     */
    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++) {
            fields[i] = new Object[]{null, null};
        }
    }

    public String toString() {

        StringBuilder result = new StringBuilder();
        for (Object[] obj : fields) {
            result.append(obj[0]);
            result.append(": ");
            result.append(obj[1]);
            result.append("\n");
        }
        return result.toString();
    }

    //返回行号
    private int hasField(String id) {
        for (int i = 0; i < fields.length; i++){
            if (id.equals(fields[i][0])) {
                return i;
            }
        }
        return -1;

    }

    //找不到抛出异常，找到了就返回行号
    private int getFieldNumber(String id) throws NoSuchFieldException {
        int fieldNum = hasField(id);
        if (fieldNum == -1) {
            throw new NoSuchFieldException();
        }
        return fieldNum;
    }

    private int makeField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        }

        // No empty fields. Add one:  临时二位数组  满了
        Object[][] tmp = new Object[fields.length + 1][2];
        for (int i = 0; i < fields.length; i++) {
            tmp[i] = fields[i];
        }
        for (int i = fields.length; i < tmp.length; i++) {
            tmp[i] = new Object[]{null, null};
        }
        fields = tmp;
        // Recursive call with expanded fields:  自己调用自己在存进去
        return makeField(id);
    }

    //通过id找异常
    public Object getField(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }

    //存一对数据
    public Object setField(String id, Object value) throws DynamicFieldsException {

        if (value == null) {
            // Most exceptions don't have a "cause" constructor.
            // In these cases you must use initCause(),
            // available in all Throwable subclasses.
            DynamicFieldsException dfe = new DynamicFieldsException();
            //自定义异常关联另一个异常一起返回，链接起来空指针异常
            dfe.initCause(new NullPointerException());
            throw dfe;
        }

        int fieldNumber = hasField(id);
        if (fieldNumber == -1) {
            fieldNumber = makeField(id);
        }
        Object result = null;
        try {
            result = getField(id); // Get old value
        } catch (NoSuchFieldException e) {
            // Use constructor that takes "cause":
            throw new RuntimeException(e);
        }
        fields[fieldNumber][1] = value;
        return result;
    }



    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        print(df);

        try {
            df.setField("d", "A value for d");
            df.setField("number", 47);
            df.setField("number2", 48);
            print(df);
            //没有重复添加，找到了相同的就存进。
            df.setField("d", "A new value for d");
            df.setField("number3", 11);
            print("df: " + df);

            print("df.getField(\"d\") : " + df.getField("d"));

            Object field = df.setField("d", null); // Exception

        } catch (NoSuchFieldException e) {
            e.printStackTrace(System.out);
        } catch (DynamicFieldsException e) {
            e.printStackTrace(System.out);
        }
    }
} /* Output:
null: null
null: null
null: null

d: A value for d
number: 47
number2: 48

df: d: A new value for d
number: 47
number2: 48
number3: 11

df.getField("d") : A new value for d
DynamicFieldsException
        at DynamicFields.setField(DynamicFields.java:64)
        at DynamicFields.main(DynamicFields.java:94)
Caused by: java.lang.NullPointerException
        at DynamicFields.setField(DynamicFields.java:66)
        ... 1 more
*///:~
