package io;

import java.nio.IntBuffer;

/**
 * @packgeName: io
 * @ClassName: BufferDemo
 * @copyright: CopyLeft
 * @description:<描述>
 * @author: lili
 * @date: 2017/9/9-19:13
 * @version: 1.0
 * @since: JDK 1.8
 */
public class BufferDemo {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        System.out.println("mark:"+intBuffer.mark()+" position:"+intBuffer.position()+" limit:"+intBuffer.limit()+" capacity:"+intBuffer.capacity());
        intBuffer.put(3);
        int temp[] = {1,2,3,};
        intBuffer.put(temp);
        System.out.println("mark:"+intBuffer.mark()+" position:"+intBuffer.position()+" limit:"+intBuffer.limit()+" capacity:"+intBuffer.capacity());
//        intBuffer.clear();
        intBuffer.get(1);
        System.out.println("mark:"+intBuffer.mark()+" position:"+intBuffer.position()+" limit:"+intBuffer.limit()+" capacity:"+intBuffer.capacity());
    }
}
