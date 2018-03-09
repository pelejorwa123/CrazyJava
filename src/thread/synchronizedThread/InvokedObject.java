package thread.synchronizedThread;

/*
*@author: pele
*@time: 2018/3/2 10:32
*@project: CrazyJava
*@description:
*/
class FirstThread extends Thread{
    InvokedObject object;
    public void setObeject(InvokedObject obeject){
        this.object = obeject;
    }
    @Override
    public void run(){
        try {
            //线程执行object的同步方法，此时会对object上锁
            object.synMethod();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
//这个线程调用的是object的第二个同步方法
class SecondThread extends Thread{
    InvokedObject object;
    public void setObeject(InvokedObject obeject){
        this.object = obeject;
    }
    @Override
    public void run(){
        try {
            //访问object的非同步方法，不会对object上锁
            object.nonSynMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreeThread extends Thread{
    InvokedObject object;
    public void setObeject(InvokedObject obeject){
        this.object = obeject;
    }
    @Override
    public void run(){
        try {
            //线程执行object的第二个同步方法，此时会对object上锁
            object.synSecondMethod();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class InvokedObject {
    //定义同步方法
    public synchronized void synMethod() throws InterruptedException {
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"--"+i);
            Thread.sleep(10);
        }
    }
    //定义非同步方法
    public void nonSynMethod() throws InterruptedException {
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"--"+i);
            Thread.sleep(10);
        }
    }
    //定义另外一个同步方法
    public synchronized void synSecondMethod() throws InterruptedException {
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"~~"+i);
            Thread.sleep(10);
        }
    }
    public static void main(String[] args){
        InvokedObject object = new InvokedObject();
        //启动三个线程，都是访问同一个object对象
        //启动两个访问同步方法的线程，它们不能执行
        FirstThread threadOne = new FirstThread();
        threadOne.setObeject(object);
        threadOne.start();
        FirstThread threadTwo = new FirstThread();
        //假如创建的是第三种线程，访问的是另一个同步方法，依然不能同时执行
        //ThreeThread threadTwo = new ThreeThread();
        threadTwo.setObeject(object);
        threadTwo.start();
        //再启动一个访问object的非同步方法，它可以与前面的线程同时执行
        SecondThread threadThree = new SecondThread();
        threadThree.setObeject(object);
        threadThree.start();
    }
}
