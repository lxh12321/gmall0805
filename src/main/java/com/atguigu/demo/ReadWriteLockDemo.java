package com.atguigu.demo;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache {
    private volatile Map<String, String> map = new HashMap<>();
    ReentrantReadWriteLock rrw=new ReentrantReadWriteLock();
    public void put(String key, String value) {
        rrw.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 写入开始");

            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入结束");
        } finally {
           rrw.writeLock().unlock();
        }
    }

    public void get(String key) {
       rrw.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 读取开始");
            String result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取结束" + result);
        } finally {
         rrw.readLock().unlock();
        }
    }
}
   /* private Lock lock = new ReentrantLock();

    public void put(String key, String value) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 写入开始");

            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入结束");
        } finally {
            lock.unlock();
        }
    }

    public void get(String key) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 读取开始");
            String result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取结束" + result);
        } finally {
            lock.unlock();
        }
    }
}*/
public class ReadWriteLockDemo {
       public static void main(String[] args) {
           MyCache myCache = new MyCache();
           for (int i = 0; i < 10; i++) {
               final int temI = i;
               new Thread(() -> {
                   myCache.put(temI + "", temI + "");
               }, String.valueOf(i)).start();
           }
           for (int i = 0; i < 10; i++) {
               final int temI = i;
               new Thread(() -> {
                   myCache.get(temI + "");
               }, String.valueOf(i)).start();
           }
       }
   }
