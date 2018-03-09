package thread.synchronizedThread;

/*
*@author: pele
*@time: 2018/3/2 13:45
*@project: CrazyJava
*@description:
*/
public class Account {
    //封装账户编号，账户余额的两个成员变量
    private String accountNo;
    private double balance;
    // 标识账户中是否已有存款flag
    private boolean flag = false;
    public Account(){}
    public Account(String accountNo,double balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }
    //省略accountNo的setter和getter方法
    //因为账户余额不能随便修改，所以只为balance提供getter方法
    public double getBalance(){
        return balance;
    }
    //取钱函数
    public synchronized void draw(double drawCount){
        try{
            //如果flag为false，表明账户里面还没有存钱进去，取钱方法阻塞
            if(!flag){
                wait();
            }else{
                //执行取钱操作
                System.out.println(Thread.currentThread().getName()
                +"取钱"+drawCount);
                balance -= drawCount;
                System.out.println("账户余额为"+balance);
                //将flag重新置回false
                flag = false;
                //唤醒其他线程
                notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //存钱函数
    public synchronized void deposit(double depositAccount){
        try{
            //如果flag为真，表明账户中已有人存进去
            if(flag){
                wait();
            }else{
                //执行存钱操作
                System.out.println(Thread.currentThread().getName()
                +"存钱"+depositAccount);
                balance += depositAccount;
                System.out.println("账户余额为"+balance);
                //将flag重新置为true
                flag = true;
                //唤醒其他线程
                notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
