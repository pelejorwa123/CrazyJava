package chapter6.SimpleFactory;

/*
*@author: pele
*@time: 2018/2/1 9:29
*@project: CrazyJava
*@description:简单工厂类
*/
public class SimpleFactory {
    public Output getOutput(){
        //return new Printer();
        return new BetterPrinter();
    }
    public static void main(String[] args){
        SimpleFactory factory = new SimpleFactory();
        Computer computer = new Computer(factory.getOutput());
        computer.keyIn("pele");
        computer.print();
    }
}
