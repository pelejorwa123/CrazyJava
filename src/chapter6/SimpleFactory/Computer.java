package chapter6.SimpleFactory;

/*
*@author: pele
*@time: 2018/2/1 9:24
*@project: CrazyJava
*@description:电脑类，实现了Output接口
*/
public class Computer {
    private Output output;
    public Computer(Output output){
        this.output = output;
    }
    public void keyIn(String msg){
        output.getData(msg);
    }
    public void print(){
        output.out();
    }
}
