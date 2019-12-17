package com.atguigu.demo;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Print{

        private int flag=1;
        private Lock lock=new ReentrantLock();

        private Condition c1=lock.newCondition();
        private Condition c2=lock.newCondition();
        private Condition c3=lock.newCondition();
        public void print5() throws InterruptedException {
            lock.lock();
            try {
                while (flag != 1) {
                    c1.await();
                }
                for (int i = 1; i <= 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }
                flag = 2;
                c2.signal();
            } finally {
                lock.unlock();
            }
        }
    public void print10() throws InterruptedException{
        lock.lock();
        try {
            while(flag!=2){
                c2.await();
            }
            for (int i = 1; i <=10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            flag=3;
            c3.signal();
        }finally {
            lock.unlock();
        }
    }
    public void print15() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 3) {
                c3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            flag = 1;
            c1.signal();
        } finally {
            lock.unlock();
        }
    }
}
public class ThreadOrderAccess {
    public static void main(String[] args) {
        Print print =new Print();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
              try {
                  print.print5();
              }catch (InterruptedException e){
                  e.printStackTrace();
              }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    print.print10();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    print.print15();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"C").start();
    }
}
