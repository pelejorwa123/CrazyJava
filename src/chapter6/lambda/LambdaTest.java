package chapter6.lambda;

/*
*@author: pele
*@time: 2018/2/6 12:26
*@project: CrazyJava
*@description:使用Runnable接口测试lambda表达式
*/
public class LambdaTest {
    public static void main(String[] args) {
        //Runnable接口中只有一个无参方法
        //lambda表达式代表的匿名方法实现了Runnable接口唯一的方法
        //因此下面的lambda表达式创建了一个Runnable对象
        Runnable r = () -> {
            System.out.println("lambda test");
        };
        r.run();
        //lambda表达式的目标类型必须是明确的函数式接口
        //必须强制转换成函数式接口，否则编译报错
        Object object = (Runnable)() -> {
            System.out.println("强制转换成Runnable的Obejct");
        };

    }
}
