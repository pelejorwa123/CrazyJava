package thread.synchronizedThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
*@author: pele
*@time: 2018/3/2 17:57
*@project: CrazyJava
*@description:线程池示例
*/
public class ThreadPoolTest {
    public static void main(String[] args){
        //创建一个具有固定线程数的线程数
        ExecutorService pool = Executors.newFixedThreadPool(6);
        Runnable target = () -> {
           for(int i=0;i<100;i++){
               System.out.println(Thread.currentThread().getName()+"--"+i);
           }
        };
        pool.submit(target);
        pool.submit(target);
        //关闭线程池
        pool.shutdown();
    }
}
