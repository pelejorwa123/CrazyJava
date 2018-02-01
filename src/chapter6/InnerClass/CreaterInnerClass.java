package chapter6.InnerClass;

/*
*@author: pele
*@time: 2018/2/1 10:54
*@project: CrazyJava
*@description:在外部类外创建内部类
*/
class Out{
    class In{
        public In(String msg){
            System.out.println(msg);
        }
    }
}
public class CreaterInnerClass {
    public static void main(String[] args){
        Out.In in = new Out().new In("test");
        /*
        * 上面代码可以改为如下代码
        * Out.In in;
        * 创建外部类实例
        * Out out = new Out();
        * 通过外部类实例和new来调用内部类构造器来创造非静态内部类实例
        * in = out.new In("test");
        * */
    }
}
