package com.atguigu.demo;

import java.util.concurrent.TimeUnit;

public class StackDemo {
    public static void test1(){
        System.out.println("222222");
         try {
             TimeUnit.SECONDS.sleep(2);
                 }catch (Exception e){
                      e.printStackTrace();
                 }
        System.out.println("33333");

    }
    public int add(int x, int y){
        int result=1;
        result=x+y;
        return  result;
    }

    public static void main(String[] args) {
        System.out.println("111111");
        test1();
        System.out.println("4444444");
    }
}
