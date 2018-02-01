package chapter5;

/*
*@author: pele
*@time: 2018/1/31 11:17
*@project: CrazyJava
*@description:父类和子类构造器调用顺序问题
*/
class Creature{
    public Creature(){
        System.out.println("Creatrue无参构造函数");
    }
}
class Animal extends Creature{
    public Animal(String name){
        System.out.println("Animal带一个参数的构造器，" +
                "该动物的name为:"+name);
    }

    public Animal(String name,int age){
        this(name);
        System.out.println("Animal带有两个参数的构造器，" +
                "其age为:"+age);
    }
}
public class Wolf extends Animal {
    public Wolf(){
        //显示调用父类的构造函数
        super("灰太狼",3);
        System.out.println("Wolf无参数的构造函数");
    }
    public static void main(String[] args){
        Wolf wolf = new Wolf();
    }
}

