//: net/mindview/util/BinaryFile.java
// Utility for reading files in binary form.
package net.mindview.util;

import java.io.*;

public class BinaryFile {

    public static byte[] read(File bFile) throws IOException {
        //字节相关的要想到InputStream，字符相关的要想到Reader
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));

        try {
            //获取有效的字节数
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        } finally {
            bf.close();
        }
    }

    public static byte[] read(String bFile) throws IOException {
        return read(new File(bFile).getAbsoluteFile());
    }
} ///:~
