package cn.edu.bjfu.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author Chao Huaiyu
 * @date 2020/11/7
 */
public class BufferTest {

    @Test
    public void bufferTest1(){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
    }

}
