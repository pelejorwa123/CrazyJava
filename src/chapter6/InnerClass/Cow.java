package chapter6.InnerClass;

/*
*@author: pele
*@time: 2018/2/1 10:32
*@project: CrazyJava
*@description:Cow包含非静态内部类CowLeg
*/
public class Cow {
    private double weight;
    public Cow(){}
    public Cow(double weight){
        this.weight = weight;
    }
    //定义非静态内部类CowLeg
    private class CowLeg{
        //不可以在非静态内部类中定义static成员
        //定义非静态内部类的两个实例变量
        private double length;
        private String color;
        public CowLeg(){}
        public CowLeg(double length,String color){
            this.length = length;
            this.color = color;
        }
        //非静态内部类的实例方法
        public void info(){
            System.out.println("color:"+color+",length"+length
            //直接访问外部类的private成员变量
                    +",weight:"+weight);
        }
    }
    //定义创建内部类的方法
    public void test(){
        //先创建实例，才能调用方法
        CowLeg cowLeg = new CowLeg(1.12,"black");
        cowLeg.info();
    }
    public static void main(String[] args){
        Cow cow = new Cow(378.9);
        cow.test();
    }
}
