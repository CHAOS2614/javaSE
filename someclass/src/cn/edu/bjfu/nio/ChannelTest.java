package cn.edu.bjfu.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Chao Huaiyu
 * @date 2020/11/8
 */
public class ChannelTest {

    @Test
    public void channelTest1() {
        //获取相关资源
        try (FileInputStream fileInputStream = new FileInputStream("images\\fragile.JPG");
             FileOutputStream fileOutputStream = new FileOutputStream("images\\fragile3.JPG");
             FileChannel inChannel = fileInputStream.getChannel();
             FileChannel outChannel = fileOutputStream.getChannel()) {

            //分配指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //将数据存入缓冲区
            while (inChannel.read(buffer) != -1) {
                //切换读取数据模式
                buffer.flip();
                //读取缓冲区数据通过通道写入内存
                outChannel.write(buffer);
                //清空缓冲区
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
