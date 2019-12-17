package com.atguigu.demo;

import org.elasticsearch.index.mapper.SourceToParse;

import java.util.concurrent.TimeUnit;

class Phone{
    public static synchronized  void sendMsg() throws Exception{
        TimeUnit.SECONDS.sleep(3);
        System.out.println("send msg!!!!!!!!!!!!!!!!!!");
    }
    public static synchronized  void sendEmail() throws Exception{
        System.out.println("send email!!!!!!!!!!!!!!!!!!");
    }
    public  void sayHello(){
        System.out.println("say Hello!!!!!!!!!!!!!!");
    };

}
public class Lock8 {
    public static void main(String[] args)throws Exception {
        Phone phone =new Phone();
        Phone phone2 =new Phone();
        new Thread(()->{
            try {
                phone.sendMsg();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        new Thread(()->{
            try {
            // phone.sendEmail();
               // phone.sayHello();
                phone2.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();

    }
}
