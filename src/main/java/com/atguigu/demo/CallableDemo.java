package com.atguigu.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class Mythread implements Runnable{

    @Override
    public void run() {

    }
}
class Mythread2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("!!!!!!!!!!!!!!!!!!!come in call");
        return 1024;
    }
}
public class CallableDemo {
    public static void main(String[] args) throws Exception{
        FutureTask futureTask =new FutureTask(new Mythread2());
        new Thread(futureTask,"A").start();
        System.out.println(futureTask.get());
    }
}
