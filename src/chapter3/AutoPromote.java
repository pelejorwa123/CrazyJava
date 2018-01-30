package chapter3;

/*
*@author: pele
*@time: 2018/1/29 13:30
*@project: CrazyJava
*@description:表达式类型的自动提升
*/
public class AutoPromote {

    public static void main(String[] args) {
        //定义一个short类型变量
        short sValue = 5;
        //表达式中的svalue将自动提升为int类型，则右边的表达式结果为int
        //将一个int类型赋值给short类型变量将发生错误
        //下面的语句错误
        //sValue = sValue - 2；
    }
}
