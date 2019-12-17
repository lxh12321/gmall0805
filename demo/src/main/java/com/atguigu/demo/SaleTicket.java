package com.atguigu.demo;


import org.elasticsearch.index.mapper.SourceToParse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.google.common.collect.ComparisonChain.start;

class Ticket{
    private int number=30;
    private Lock lock =new ReentrantLock();
    public synchronized  void  sale(){
        lock.lock();
        try {
            if(number>0){
                System.out.println(Thread.currentThread().getName()+"\t卖出第:"+(number--)+"\t还剩下:"+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }
}
 public class SaleTicket {

     public static void main(String[] args) {
         ExecutorService threadPool1= Executors.newFixedThreadPool(3);
         Ticket ticket =new Ticket();
         try {
             for (int i =1; i <=31; i++) {
                 final int Tempi=i;
                 threadPool1.execute(()->{
                     ticket.sale();
                 });
             }
         }finally {
            threadPool1.shutdown();
         }


//        Ticket ticket =new Ticket();
//        new Thread(()->{ for (int i = 1; i <35 ; i++) ticket.sale(); },"A").start();
//        new Thread(()->{ for (int i = 1; i <35 ; i++) ticket.sale(); },"B").start();
//        new Thread(()->{ for (int i = 1; i <35 ; i++) ticket.sale(); },"C").start();

            /*new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1; i <35 ; i++) {
                        ticket.sale();
                    }
                }
            }, "A").start();





        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <35 ; i++) {
                    ticket.sale();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <35 ; i++) {
                    ticket.sale();
                }
            }
        }, "C").start();*/
    }
}

