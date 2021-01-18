package com.tong.java2;

/**
 * Created by HappyTong
 * Date on 2021/1/5 20:51
 */
public class BankTest {
}
class Bank{
    private Bank(){}
    private static Bank instance = null;
    public static synchronized Bank getInstance(){
        if (instance == null){
            instance = new Bank();
        }
        return instance;
    }
}
