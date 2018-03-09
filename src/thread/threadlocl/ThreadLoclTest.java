package thread.threadlocl;

/*
*@author: pele
*@time: 2018/3/2 19:03
*@project: CrazyJava
*@description:ThreadLocal类使用示例
*/
class Account{
    //定义一个ThreadLocal类型的变量，该变量将是一个线程局部变量
    //每个线程都会保留该变量的一个副本
    private ThreadLocal<String> name = new ThreadLocal<>();
    public Account(String name){
        this.name.set(name);
    }
    public String getName(){
        return this.name.get();
    }
    public void setName(String name){
        this.name.set(name);
    }
}
class MyTest extends Thread{
    private Account account;
    public MyTest(Account account,String name){
        super(name);
        this.account = account;
    }
    public void run(){
        //循环十次
        for(int i=0;i<10;i++){
            //当i==6时输出将帐户名换成当前线程名
            if(i == 6){
                account.setName(getName());
            }
            System.out.println(account.getName()+"--"+i);
        }
    }
}
public class ThreadLoclTest {
    public static void main(String[] args){
        //启动一个线程，两个线程共享同一个Account
        Account at = new Account("初始化");
        /*
        * 虽然两个线程共享同一个Account账户，即只有一个帐户名
        * 但由于帐户名是ThreadLocal类型的，所以每个线程
        * 都完全拥有帐户名副本，因此在i==6之后，将看到两个
        * 线程访问同一个账户时出现不同的帐户名
        * */
        new MyTest(at,"线程甲").start();
        new MyTest(at,"线程乙").start();
    }
}
