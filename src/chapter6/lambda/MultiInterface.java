package chapter6.lambda;

/*
*@author: pele
*@time: 2018/2/6 13:01
*@project: CrazyJava
*@description:一个lambda表达式的目标类型可以是不同的函数式接口
*/
@FunctionalInterface
interface FkTest{
    void run();
}

public class MultiInterface {
    public static void main(String[] args){
        //FkTest接口和Runnable都是函数式接口，且方法形参列表相同
        //所以使用lambda表达式的目标类型既可以是FkTest，也可以是Runnable
        FkTest fkTest = () -> {
            System.out.println("这是FkTest接口的lambda表达式");
        };
        Runnable runnable = () -> {
            System.out.println("这是Runnable接口的lambda表达式");
        };
        fkTest.run();
        runnable.run();
    }
}
