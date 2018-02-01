package chapter6.SimpleFactory;

/*
*@author: pele
*@time: 2018/2/1 9:28
*@project: CrazyJava
*@description:打印机，实现output接口
*/
public class Printer implements Output{
    private String msg;
    @Override
    public void getData(String msg) {
        this.msg = msg;
    }
    @Override
    public void out() {
        System.out.println("this is printer:"+msg);
    }
}
