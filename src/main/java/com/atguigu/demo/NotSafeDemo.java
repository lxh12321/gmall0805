package com.atguigu.demo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class NotSafeDemo {
    public static void main(String[] args) {
        Map<String ,String>map =new ConcurrentHashMap<>();




//        Set<String>set= new CopyOnWriteArraySet<>();//Collections.synchronizedSet(new HashSet<>());//new HashSet<>();
//        new HashSet<>().add("a");
//        for (int i = 0; i <=30 ; i++) {
//            new Thread(()->{
//                set.add(UUID.randomUUID().toString().substring(0,6));
//                System.out.println(set);
//            },String.valueOf(i)).start();
//        }
    }
}
