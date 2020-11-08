package cn.edu.bjfu.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;

/**
 * @author Chao Huaiyu
 * @date 2020/11/8
 */
public class NonBlockingNioTest {

    @Test
    public void client() {
        //获取通道
        try (SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898))) {

            //切换非阻塞模式
            socketChannel.configureBlocking(false);

            //分配指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //发送数据
            buffer.put(new Date().toString().getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void server() throws IOException {
        //获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //切换非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //绑定连接
        //绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9898));
        //获取选择器
        Selector selector = Selector.open();
        //将通道注册到选择器上，病指定"监听接收事件"
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //轮询式的获取选择器上已经准备就绪的事件
        while (selector.select() > 0) {
            //获取当前选择器中注册的“选择键（已就绪的监听事件）”
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                //判断具体是什么事件准备就绪
                //如果是“接收就绪”，则获取客户端连接
                if (next.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    //将该通道注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (next.isReadable()) {
                    //获取当前选择器上“读就绪”状态的通道
                    SocketChannel socketChannel = (SocketChannel) next.channel();

                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    int len;
                    while ((len = socketChannel.read(buffer)) > 0) {
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, len));
                    }
                }
                iterator.remove();
            }
        }
    }
}

