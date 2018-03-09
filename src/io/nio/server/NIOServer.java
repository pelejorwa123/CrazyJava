package io.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/*
*@author: pele
*@time: 2018/3/3 10:56
*@project: CrazyJava
*@description:
*/
public class NIOServer {
    //通道管理器
    private Selector selector;
    public void initServer(int port) throws Exception{
        //获取一个ServerSocket通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        //要使用Selector，必须设置为非阻塞
        serverChannel.configureBlocking(false);
        //将该通道对应的ServerScoket绑定port端口
        serverChannel.socket().bind(new InetSocketAddress(port));
        //获取一个Selector
        selector = Selector.open();
        //为该通道注册兴趣事件
        SelectionKey key = serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        //可以根据得到的这个key访问信息
    }
    public void listen() throws IOException {
        //采用轮询的方式监听Selector上是否有需要处理的事件
        while (true) {
            //调用select方法
            //当注册事件到达时，方法返回，否则一直阻塞
            int count = selector.select();
            //获取Selector选中的SelectorKey的迭代器
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                //删除已处理的key，以防重复处理
                iterator.remove();
                //客户端请求连接事件
                if(key.isAcceptable()){
                    ServerSocketChannel sever = (ServerSocketChannel) key.channel();
                    //获取和客户端连接的通道
                    SocketChannel channel = sever.accept();
                    //设置为非阻塞
                    channel.configureBlocking(false);
                    //在这里可以发送消息给客户端
                    channel.write(ByteBuffer.wrap(new String("hello client").
                            getBytes()));
                    //在客户端连接成功后，为了可以接受到消息，需要注册读事件的监听
                    channel.register(selector,SelectionKey.OP_READ);
                }else if(key.isReadable()){
                    read(key);
                }
            }
        }
    }
    //处理读取客户端发来的信息事件
    public void read(SelectionKey key) throws IOException {
        //服务器可读消息，得到事件发生的scoket通道
        SocketChannel channel = (SocketChannel) key.channel();
        //生成读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        channel.read(buffer);
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("server receive from client："+msg);
        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
        //由向channel中echo发送的消息
        channel.write(outBuffer);
    }
    public static void main(String[] args) throws Exception {
        NIOServer server = new NIOServer();
        server.initServer(8989);
        server.listen();
    }
}
