package chapter6.InnerClass;

/*
*@author: pele
*@time: 2018/2/1 12:05
*@project: CrazyJava
*@description:匿名内部类
*/
abstract class Device{
    private String name;
    public abstract double getPrice();
    public Device(){};
    public Device(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
public class AnonymousInner {
    public void test(Device d){
        System.out.println("name:"+d.getName()+",price:"+d.getPrice());
    }
    public static void main(String[] args){
        AnonymousInner ai = new AnonymousInner();
        //调用有参数的构造器来创建device匿名实现类的对象
        ai.test(new Device("电子示波器") {
            @Override
            public double getPrice() {
                return 67.8;
            }
        });
        //调用无参构造器创建device匿名实现类的对象
        Device d = new Device() {
            //初始化块
            {
                System.out.println("匿名内部类的初始化块...");
            }
            @Override
            public double getPrice() {
                return 56.2;
            }
            //重写父类的实例方法
            public String getName(){
                return "键盘";
            }
        };
        ai.test(d);
    }
}
