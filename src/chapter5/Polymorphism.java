package chapter5;

/*
*@author: pele
*@time: 2018/1/31 11:42
*@project: CrazyJava
*@description:多态
*/
class BaseClass{
    public int book = 6;
    public void test(){
        System.out.println("现在是BaseClass的test方法");
    }
}
class SubClass extends BaseClass{
    public int book = 7;
    @Override
    public void test(){
        System.out.println("这是SubClass的test方法");
        //在重写的方法内，访问的成员变量是子类的成员变量
        System.out.println("子类的book："+book);
    }
}
public class Polymorphism {

    public static void main(String[] args){
        BaseClass baseClass = new SubClass();
        baseClass.test();
        //直接使用父类引用访问的是父类的成员变量
        System.out.println("父类的book："+baseClass.book);
    }
}
