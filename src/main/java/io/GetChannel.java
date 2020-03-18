package io;//: io/GetChannel.java
// Getting channels from streams

import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class GetChannel {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        // Write a file:
        String path = "D:\\MavenSpace\\thinkinjava\\src\\main\\java\\io\\";
        FileChannel fc = new FileOutputStream(path+"GetChannel.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        for (byte b : "Some text".getBytes()) {
            System.out.print(b);
        }
        fc.close();

        // Add to the end of the file:
        fc = new RandomAccessFile(path+"GetChannel.txt", "rw").getChannel();
        fc.position(fc.size()); // Move to the end
        //在文件最后写入
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();

        // Read the file:
        fc = new FileInputStream(path+"GetChannel.txt").getChannel();
        // 通道和buffer打交道
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()) {
            System.out.print((char) buff.get());
        }
    }
} /* Output:
Some text Some more
*///:~
