package thread.current;

import java.util.concurrent.CountDownLatch;

/*
*@author: pele
*@time: 2018/3/9 14:36
*@project: CrazyJava
*@description:CountDownLatch示例
*/
public class CountDownLatchTest {
    public static void main(String[] args){
        final CountDownLatch latch = new CountDownLatch(2);
        //启动第一个子线程
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    //将计数器减一
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        //再启动第二个线程
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    //将计数器减一
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try{
            System.out.println("等待两个子线程执行完毕...");
            //调用计数器的阻塞方法阻塞当前线程，直到计数器计数完成会自动唤醒当前阻塞的线程
            latch.await();
            System.out.println("子线程已经全部执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
