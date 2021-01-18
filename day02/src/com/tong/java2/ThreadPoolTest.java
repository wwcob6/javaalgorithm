package com.tong.java2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by HappyTong
 * Date on 2021/1/11 22:06
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executor =  Executors.newFixedThreadPool(10);
        //设置线程池属性
        ThreadPoolExecutor executor1 = (ThreadPoolExecutor) executor;
        NumberTask numberTask = new NumberTask();
        NumberTask1 numberTask1 = new NumberTask1();
        executor.execute(numberTask);
        executor.execute(numberTask1);
        executor.shutdown();
    }
}
class NumberTask implements Runnable{
    @Override
    public void run() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 ==0){
                System.out.println(i);
                System.out.println(Thread.currentThread().getName());
                sum += i;
            }
        }
    }
}
class NumberTask1 implements Runnable{
    @Override
    public void run() {
        int sum1 = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 !=0){
                System.out.println(i);
                System.out.println(Thread.currentThread().getName());
                sum1 += i;
            }
        }
    }
}