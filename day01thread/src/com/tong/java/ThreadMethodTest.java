package com.tong.java;

/**
 * Created by HappyTong
 * Date on 2021/1/4 21:24
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread("你好");
        // 设置优先级
        helloThread.setPriority(Thread.MAX_PRIORITY);
        helloThread.start();
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i + "\n"
                + helloThread.getPriority());
            }
            if (i == 20 ){
                try {
                    helloThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class HelloThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 ==0){
                try {
                    sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":" + i + "\n" + getPriority());
            }
        }
    }
    public HelloThread(String name){
        super(name);
    }
}