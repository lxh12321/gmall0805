package com.atguigu.demo;

import java.util.concurrent.*;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool= new ThreadPoolExecutor(2,5,1l, TimeUnit.SECONDS,new LinkedBlockingDeque<>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardOldestPolicy());
        try {
                 for (int i = 1; i <=9;i++) {
                     final int temi=i;
                             threadPool.execute(()->{ System.out.println(Thread.currentThread().getName()+"\t 受理业务"+temi);
                             });
                               }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }


    }
}
