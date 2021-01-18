package com.tong.java;

/**
 * Created by HappyTong
 * Date on 2021/1/5 20:11
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
class Window2 extends Thread{
    private static int tickets = 100;
    public static synchronized void sell(){
        while (true){
            if (tickets > 0){
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为： " + tickets);
                tickets--;
            }else {
                break;
            }
        }
    }
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sell();
        /*synchronized () {
            while (true){
                if (tickets > 0){
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为： " + tickets);
                    tickets--;
                }else {
                    break;
                }
            }
        }*/
    }
}
