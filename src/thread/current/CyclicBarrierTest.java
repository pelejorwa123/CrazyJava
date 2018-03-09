package thread.current;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/*
*@author: pele
*@time: 2018/3/9 14:56
*@project: CrazyJava
*@description:CyclicBarrier实例
*/
public class CyclicBarrierTest {
    public static void main(String[] args){
        int num = 4;
        CyclicBarrier barrier = new CyclicBarrier(num);
        for(int i=0;i<num;i++){
            new Writer(barrier).start();
        }
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
                barrier.await();
                System.out.println("子线程"+Thread.currentThread().getName()+"正在写入数据");
                Thread.sleep(3000);
                System.out.println("子线程"+Thread.currentThread().getName()+"写入数据完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
