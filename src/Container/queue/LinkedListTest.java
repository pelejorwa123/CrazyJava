package Container.queue;

import java.util.LinkedList;

/*
*@author: pele
*@time: 2018/2/12 12:55
*@project: CrazyJava
*@description:LinkedList使用示例
*/
public class LinkedListTest {
    public static void main(String[] args){
        LinkedList<String> books = new LinkedList<>();
        //将字符元素加入队列的尾部
        books.offer("疯狂java讲义");
        //将一个字符串压栈
        books.push("轻量级java ee企业应用实战");
        //将字符串元素添加到队列的头部
        books.offerFirst("疯狂Android讲义");
        //以List方法遍历元素
        for(int i=0;i<books.size();i++){
            System.out.println(books.get(i));
        }
        //访问但不删除栈顶元素
        System.out.println(books.peek());
        //访问但不删除队尾元素
        System.out.println(books.peekLast());
        //将栈顶元素出栈
        System.out.println(books.pop());
        System.out.println(books);
        //访问并删除队列的最后一个元素
        System.out.println(books.pollLast());
        System.out.println(books);
    }
}
