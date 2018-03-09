package thread.current;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*
*@author: pele
*@time: 2018/3/9 15:30
*@project: CrazyJava
*@description:使用CyclicBarrier的await(long time,TimeUnit unit)
*/
public class CyclicBarrierTest3 {
    public static void main(String[] args){
        int num = 4;
        CyclicBarrier barrier = new CyclicBarrier(num);
        for(int i=0;i<num-1;i++){
            new Writer(barrier).start();
        }
        //让最后一个子线程晚3秒创建
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Writer(barrier).start();
    }
    static class Writer extends Thread{
        private CyclicBarrier barrier;
        public Writer(CyclicBarrier barrier){
            this.barrier = barrier;
        }
        @Override
        public void run() {
            try {
                System.out.println("等待其他线程都准备好再开始执行");
                //调用await方法使当前线程阻塞，直到barrier有指定的num个线程都调用了await方法再同时唤醒这些线程
                try{
                     barrier.await(2000, TimeUnit.MILLISECONDS);
                } catch (TimeoutException e) {
                    System.out.println(Thread.currentThread().getName()+"xxxxx");
                    e.printStackTrace();
                }catch (BrokenBarrierException e) {
                    System.out.println(Thread.currentThread().getName()+"yyyyy");
                    e.printStackTrace();
                }
                System.out.println("子线程"+Thread.currentThread().getName()+"正在写入数据");
                Thread.sleep(3000);
                System.out.println("子线程"+Thread.currentThread().getName()+"写入数据完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
