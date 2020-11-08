package cn.edu.bjfu.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Chao Huaiyu
 * @date 2020/11/8
 */
public class ChannelTest {

    /**
     * 利用文件完成图片的复制（非直接缓冲区）
     */
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

    /**
     * 利用直接缓冲区完成文件的复制（内存映射文件）
     */
    @Test
    public void channelDri() {

        //获取通道资源
        try (FileChannel inChannel = FileChannel.open(Paths.get("images\\fragile.JPG"),
                StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get("images\\fragile4.JPG"),
                     StandardOpenOption.WRITE,
                     StandardOpenOption.READ,
                     StandardOpenOption.CREATE)) {

            //内存映射文件
            MappedByteBuffer inMappedBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            //直接对缓冲区数据进行读写操作
            byte[] dst = new byte[inMappedBuffer.limit()];
            inMappedBuffer.get(dst);
            outMappedBuffer.put(dst);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
