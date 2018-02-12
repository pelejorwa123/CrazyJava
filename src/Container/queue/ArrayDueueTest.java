package Container.queue;


import java.util.ArrayDeque;

/*
*@author: pele
*@time: 2018/2/12 12:45
*@project: CrazyJava
*@description:ArrayDueue类当作栈使用示例
*/
public class ArrayDueueTest {
    public static void main(String[] args){
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("疯狂java讲义");
        stack.push("轻量级java ee企业应用实战");
        stack.push("疯狂Android讲义");
        System.out.println(stack);
        //访问第一个元素，但不将其出栈
        System.out.println(stack.peek());
        System.out.println(stack);
        //将第一个元素出栈
        System.out.println(stack.pop());
        System.out.println(stack);

    }
}
