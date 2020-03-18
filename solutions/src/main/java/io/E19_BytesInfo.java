package io;

import net.mindview.util.BinaryFile;

import java.io.IOException;
import java.util.*;

/**
 * @packgeName: io
 * @ClassName: E19_BytesInfo
 * @copyright: CopyLeft
 * @description:<描述>  读取二进制文件 并计数
 * @author: lili
 * @date: 2017/9/9-12:33
 * @version: 1.0
 * @since: JDK 1.8
 */
public class E19_BytesInfo {



    public static void bytesCount(String fileName) throws IOException {

        Map<Byte, Integer> byteStats = new HashMap<Byte, Integer>();
        for (byte b : BinaryFile.read(fileName)) {
            Integer freq = byteStats.get(b);
            byteStats.put(b, freq == null ? 1 : freq + 1);
        }
        List<Byte> keys = Arrays.asList(byteStats.keySet().toArray(new Byte[0]));
        Collections.sort(keys);
        for (Byte key : keys) {
            System.out.println(key + " ====> " + byteStats.get(key));
        }
    }

    public static void main(String[] args) throws IOException {

        String path1 = "D:\\MavenSpace\\thinkinjava\\solutions\\target\\classes\\io\\E19_BytesInfo.class";
        String path2 = "D:\\MavenSpace\\thinkinjava\\solutions\\src\\main\\java\\io\\E19_BytesInfo.java";
        bytesCount(path1);
        System.out.println("---------------------");
        bytesCount(path2);
    }

}
