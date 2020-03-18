//: net/mindview/atunit/ClassNameFinder.java
package net.mindview.atunit;

import net.mindview.util.BinaryFile;
import net.mindview.util.Directory;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static net.mindview.util.Print.print;

public class ClassNameFinder {

    public static String thisClass(byte[] classBytes) {
        //存储偏移位置
        Map<Integer, Integer> offsetTable = new HashMap<Integer, Integer>();
        //存储类名
        Map<Integer, String> classNameTable = new HashMap<Integer, String>();
        try {
            //16进制文件转化为二进制 为什么要用DataInputStream？？？
            DataInputStream data = new DataInputStream(new ByteArrayInputStream(classBytes));
            int magic = data.readInt();  // 0xcafebabe 32位 4个字节  u4
            int minorVersion = data.readShort(); //16  2个字节   u2
            int majorVersion = data.readShort(); //16  2个字节   u2
            int constant_pool_count = data.readShort(); //16 常量池长度  2个字节  u2
            int[] constant_pool = new int[constant_pool_count]; //常量池
            //常量池内容  参考jclasslib.jar去理解程序以及《深入理解jvm》来看
            // 无符号数  u1 u2 u4 u8  1，2,4,8个字节
            for (int i = 1; i < constant_pool_count; i++) {
                // 读一个字节
                int tag = data.read();
                int tableSize;
                switch (tag) {
                    /**
                     * 唯独没有2  常量池11种类型
                     */
                    case 1: // UTF  u2
                        int length = data.readShort();
                        char[] bytes = new char[length];
                        for (int k = 0; k < bytes.length; k++) {
                            bytes[k] = (char) data.read();
                        }
                        String className = new String(bytes);
                        classNameTable.put(i, className);
                        break;
                    case 5: // LONG
                    case 6: // DOUBLE
                        data.readLong(); // discard 8 bytes
                        i++; // Special skip necessary
                        break;
                    case 7: // CLASS
                        int offset = data.readShort();
                        offsetTable.put(i, offset);
                        break;
                    case 8: // STRING
                        data.readShort(); // discard 2 bytes
                        break;
                    case 3:  // INTEGER
                    case 4:  // FLOAT
                    case 9:  // FIELD_REF
                    case 10: // METHOD_REF
                    case 11: // INTERFACE_METHOD_REF
                    case 12: // NAME_AND_TYPE
                        data.readInt(); // discard 4 bytes;
                        break;
                    default:
                        throw new RuntimeException("Bad tag " + tag);
                }
            }

            short access_flags = data.readShort();  //u2
            int this_class = data.readShort();//当前类  u2
            int super_class = data.readShort();//父类  u2
            //后面还有很多信息没有读取到。
            return classNameTable.get(offsetTable.get(this_class)).replace('/', '.');
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Demonstration:
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            for (String arg : args)
                print(thisClass(BinaryFile.read(new File(arg))));
        } else {
            // Walk the entire tree:
            for (File klass : Directory.walk(".", ".*\\.class")) {
                print(thisClass(BinaryFile.read(klass)));
            }
        }
    }
} ///:~
