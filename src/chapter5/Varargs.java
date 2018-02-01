package chapter5;

/*
*@author: pele
*@time: 2018/1/30 16:51
*@project: CrazyJava
*@description:形参个数可变示例
*/
public class Varargs {
    //定义形参个数可变的方法
    static void test(int a,String... books){
        //books在方法内部被当成数组处理
        for(String book:books){
            System.out.println(book);
        }
        System.out.println(a);
    }
    public static void main(String[] args){
        //可以直接这样传参数
        test(1,"a","b","c");
        //可以传数组
        test(2,new String[]{"d","e","f"});
        //可以直接不传
        test(3);
    }
}
