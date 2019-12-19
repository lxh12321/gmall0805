package com.atguigu.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception{
        BlockingQueue blockingQueue=new ArrayBlockingQueue(3 );
     blockingQueue.put("a");
        blockingQueue.put("B");
        blockingQueue.put("c");
        System.out.println("!!!!!!!!!!!!!!!!111111");
        //blockingQueue.put("a");


/*

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
*/

    }
}

