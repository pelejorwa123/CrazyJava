package io.nio;

import java.nio.CharBuffer;

/*
*@author: pele
*@time: 2018/3/2 20:43
*@project: CrazyJava
*@description:
*/
public class BufferTest {
    public static void main(String[] args){
        //创建buffer
        CharBuffer buffer = CharBuffer.allocate(8);
        System.out.println("capacity："+buffer.capacity());
        System.out.println("limit："+buffer.limit());
        System.out.println("position："+buffer.position());
        //放入元素
        buffer.put('a');
        buffer.put('b');
        buffer.put('c');
        System.out.println("加入三个元素后，position："+
        buffer.position());
        buffer.flip();
        System.out.println("执行flip后，limit："+buffer.limit());
        System.out.println("position："+buffer.position());
        //取出第一个元素
        System.out.println("第一个元素（position=0）:"+buffer.get());
        System.out.println("取出第一个元素后，position："+buffer.position());
        //调用clear()方法
        buffer.clear();
        System.out.println("执行clear后，缓冲区并没有被清除："
        +"第三个元素为："+buffer.get(2));
        System.out.println("执行绝对读取后，position:"+buffer.position());

    }
}
