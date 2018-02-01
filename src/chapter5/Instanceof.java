package chapter5;

/*
*@author: pele
*@time: 2018/1/31 11:58
*@project: CrazyJava
*@description:Instanceof运算符实例
*/
public class Instanceof {
    public static void main(String[] args){
        Object hello = "Hello";
        System.out.println(hello instanceof Object);//true
        System.out.println(hello instanceof String);//true
        System.out.println(hello instanceof Math);//false
        System.out.println(hello instanceof Comparable);//true
    }
}
