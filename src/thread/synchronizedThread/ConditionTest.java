package thread.synchronizedThread;

import javax.swing.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
*@author: pele
*@time: 2018/3/2 14:38
*@project: CrazyJava
*@description:当使用Lock时，使用Condition来进行进程间的协调
*/
class AccountWithCondition{
    //显示定义Lock对象
    private final Lock lock = new ReentrantLock();
    //获得指定的Lock对象对应的Condition
    private final Condition cond = lock.newCondition();
    //封装账户编号，账户余额的两个成员变量
    private String accountNo;
    private double balance;
    private boolean flag = false;
    public AccountWithCondition(){}
    public AccountWithCondition(String accountNo, double balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }
    //省略accountNo的setter和getter方法
    //因为账户余额不能随便修改，所以只为balance提供getter方法
    public double getBalance(){
        return balance;
    }
    public void draw(double drawCount){
        //加锁
        lock.lock();
        try{
            //如果flag为false，表明账户里面还没有存钱进去，取钱方法阻塞
            if(!flag){
                cond.await();
            }else{
                //执行取钱操作
                System.out.println(Thread.currentThread().getName()
                        +"取钱"+drawCount);
                balance -= drawCount;
                System.out.println("账户余额为"+balance);
                //将flag重新置回false
                flag = false;
                //唤醒其他线程
                cond.signalAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            //必须释放锁
            lock.unlock();
        }
    }
    //存钱函数
    public  void deposit(double depositAccount){
        try{
            //如果flag为真，表明账户中已有人存进去
            if(flag){
                cond.await();
            }else{
                //执行存钱操作
                System.out.println(Thread.currentThread().getName()
                        +"存钱"+depositAccount);
                balance += depositAccount;
                System.out.println("账户余额为"+balance);
                //将flag重新置为true
                flag = true;
                //唤醒其他线程
                cond.signalAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class ConditionTest {

}
