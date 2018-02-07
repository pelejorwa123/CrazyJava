package chapter6.lambda;

/*
*@author: pele
*@time: 2018/2/6 13:10
*@project: CrazyJava
*@description:lambda表达式匿名方法引用其他类方法
*/
@FunctionalInterface
interface Converter{
    Integer convert(String from);
}
public class MethodRefer {
    public static void main(String[] args){
        Converter converter1 = from -> Integer.parseInt(from);
        Integer val = converter1.convert("123");
        System.out.println(val);
        //方法引用代替lambda表达式:引用类方法
        //函数式接口中被实现方法的全部参数传给该类方法作为参数
        Converter converter2 = Integer::parseInt;
        converter2.convert("234");

        //引用特定实例的实例方法
        Converter converter3 = from -> "fkit.org".indexOf(from);
        converter3.convert("it");
        //方法引用代替lambda表达式：引用特定对象的实例方法
        //函数式接口中被实现方法的全部参数传给该方法作为参数
        Converter converter4 = "fkit.org"::indexOf;
        converter4.convert("it");

        //引用某类对象的实例方法

    }
}
