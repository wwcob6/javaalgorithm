package com.tong.java;

/**
 * 1、declare a class to be a subclass of Thread
 * 2、This subclass should override the run method of class Thread.
 * 3、An instance of the subclass can then be allocated and started.
 *
 * 例子：遍历100以内所有偶数
 *
 * Created by HappyTong
 * Date on 2021/1/4 20:16
 */
public class ThreadTest {
    public static void main(String[] args) {
        EvenThread evenThread = new EvenThread(10);
        // Causes this thread to begin execution; the Java Virtual Machine calls the run method of this thread.
        evenThread.start();
    }
}

class EvenThread extends Thread{
    int number;
    EvenThread(int number){
        this.number = number;
    }
    @Override
    public void run() {
        for (int i = 0; i < number; i++) {
            if (i % 2== 0){
                System.out.println(i);
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
