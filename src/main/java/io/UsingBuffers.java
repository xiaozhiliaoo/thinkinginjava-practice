package io;//: io/UsingBuffers.java

import java.nio.*;

import static net.mindview.util.Print.*;

public class UsingBuffers {

    private static void symmetricScramble(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            //设置标记
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            //重置为以前
            buffer.reset();
            buffer.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {

        char[] data = "UsingBuffers".toCharArray();
        //一个char占两个字节
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        //转换成视图转换器，不是真正存储数据的
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        //重绕回开始位置
        print(cb.rewind());
        //对称的混乱
        symmetricScramble(cb);
        print(cb.rewind());

        symmetricScramble(cb);
        print(cb.rewind());
    }
} /* Output:
UsingBuffers
sUniBgfuefsr
UsingBuffers
*///:~
