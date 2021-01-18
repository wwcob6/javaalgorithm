package com.tong.java2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程通信例子
 *
 * Created by HappyTong
 * Date on 2021/1/7 22:49
 */
public class CommunicationTest {
    public static void main(String[] args) {
        NumberPrint numberPrint = new NumberPrint();

        Thread t1 = new Thread(numberPrint);
        Thread t2 = new Thread(numberPrint);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
    static class LockCondition{
        public ReentrantLock lock = new ReentrantLock();
        public Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

    }
}
class NumberPrint implements Runnable{
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int num = 1;
    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                condition.signal();
                if (num <= 100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                    // 使得该线程进入阻塞状态
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }  finally {
                lock.unlock();
            }
        }
    }
}