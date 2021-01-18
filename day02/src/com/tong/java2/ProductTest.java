package com.tong.java2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by HappyTong
 * Date on 2021/1/10 15:16
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.setName("生产者");
        thread2.setName("顾客");
        thread1.start();
        thread2.start();
    }
}
class Clerk{
    private int num = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();
    Boolean isEmpty = false;
    Boolean isFull = false;
    public void make(){
        while (true){
            try {
                lock.lock();
                while (num >= 20){
                    try {
                        System.out.println(Thread.currentThread().getName()+"生产数量到达20");
                        full.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num++;
                System.out.println(Thread.currentThread().getName()+"当前产品数量为：" + num);
                empty.signal();
            } finally {
                lock.unlock();
            }
        }
    }
    public void sell(){
        while (true){
            try {
                lock.lock();
                while (num == 0){
                    try {
                        System.out.println(Thread.currentThread().getName()+": 商品数量为：" + num + "，无法继续售出");
                        empty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num--;
                System.out.println(Thread.currentThread().getName()+": 售出一份，当前为："+num);
                full.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
class Producer implements Runnable{
    private Clerk clerk;


    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.make();
        }
    }
}
class Consumer implements Runnable{
    private Clerk clerk;
    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.sell();
        }
    }
}

