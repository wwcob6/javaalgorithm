package com.tong.java;

/**
 * 在并发编程中存在线程安全问题，主要原因有：
 * 1.存在共享数据
 * 2.多线程共同操作共享数据。
 * 关键字synchronized可以保证在同一时刻，只有一个线程可以执行某个方法或某个代码块
 *
 * Created by HappyTong
 * Date on 2021/1/5 15:54
 */
public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
class Dog{

}
class Window implements Runnable{
    private int tickets = 100;
    Dog dog = new Dog();
    /*public synchronized void sellTickets(){
        while (true){
            if (tickets > 0){
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为： " + tickets);
                tickets--;
            }else {
                break;
            }
        }
    }*/
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (dog) {
            while (true){
                if (tickets > 0){
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为： " + tickets);
                    tickets--;
                }else {
                    break;
                }
            }
        }
    }
}