package com.atguigu.demo;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args)  {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()-> { System.out.println("!!!!!!!!!召唤神龙");});
            for (int i = 1; i <= 7; i++) {
                final int tempI=i;
                new Thread(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName()+"\t 收集到第"+tempI+"颗龙珠");
                            cyclicBarrier.await();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }catch (BrokenBarrierException e){
                        e.printStackTrace();
                    }
                }, String.valueOf(i)).start();
            }

        }
    }


