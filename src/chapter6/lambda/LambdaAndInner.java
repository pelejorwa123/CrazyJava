package chapter6.lambda;

/*
*@author: pele
*@time: 2018/2/6 14:11
*@project: CrazyJava
*@description:lambda表达式和匿名内部类
*/
@FunctionalInterface
interface Displayable{
    //定义一个抽象方法和默认方法
    void display();
    default int add(int a,int b){
        return a+b;
    }
}
public class LambdaAndInner {
    private int age =12;
    private static String name = "疯狂软件教育中心";
    public void test(){
        String book = "疯狂java讲义";
        Displayable displayable = () -> {
            //访问"effectively final"的局部变量
            System.out.println("book局部变量为："+book);
            //访问外部类的实例变量和类变量
            System.out.println("外部类的age实例变量："+age);
            System.out.println("外部类的name类变量："+name);
            //不允许在lambda表达式代码块调用接口的默认方法
            //System.out.println(add(3,5));
        };
        displayable.display();
        //调用dis对象从接口中继承的add()方法
        System.out.println(displayable.add(3,5));
    }
    public static void main(String[] args){
        LambdaAndInner lambdaAndInner = new LambdaAndInner();
        lambdaAndInner.test();
    }

}
