package com.atguigu.demo;

import io.netty.channel.ThreadPerChannelEventLoopGroup;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirControl{
    private int number=0;
    private Lock lock =new ReentrantLock();
    private Condition condition=lock.newCondition();
    public  void add() throws Exception{
        lock.lock();
        try {
        while(number!=0){
            condition.await();
        }
        ++number;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
       condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public  void dec() throws Exception{
        lock.lock();
        try {
            while(number==0){
                condition.await();
            }
            --number;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
//    public synchronized  void add() throws Exception{
//        while(number!=0){
//            this.wait();
//        }
//        ++number;
//        System.out.println(Thread.currentThread().getName()+"\t"+number);
//        this.notifyAll();
//    }
//    public synchronized  void add() throws Exception{
//        while(number!=0){
//            this.wait();
//        }
//        ++number;
//        System.out.println(Thread.currentThread().getName()+"\t"+number);
//        this.notifyAll();
//    }
//    public synchronized void dec() throws Exception{
//        while(number==0){
//            this.wait();
//        }
//        --number;
//        System.out.println(Thread.currentThread().getName()+"\t"+number);
//        this.notifyAll();
//    }
//}
//
//public class ThreadWaitNotifyDemo {
//    public static void main(String[] args) throws  Exception{
//        AirControl airControl =new AirControl();
//         new Thread(()->{
//            for (int i = 1; i <=10 ; i++) {
//                try {
//                    airControl.add();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        },"A").start();
//        new Thread(()->{
//            for (int i = 1; i <=10 ; i++) {
//                try {
//                    airControl.dec();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        },"B").start();
//        new Thread(()->{
//            for (int i = 1; i <=10 ; i++) {
//                try {
//                    airControl.add();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        },"C").start();
//        new Thread(()->{
//            for (int i = 1; i <=10 ; i++) {
//                try {
//                    airControl.dec();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        },"D").start();
//    }
}
