package chapter6.SimpleFactory;

/*
*@author: pele
*@time: 2018/2/1 9:33
*@project: CrazyJava
*@description:升级版的打印机，实现了Output接口
*/
public class BetterPrinter implements Output{
    private String msg;
    @Override
    public void getData(String msg) {
        this.msg = msg;
    }
    @Override
    public void out() {
        System.out.println("this is betterprinter:"+msg);
    }
}
