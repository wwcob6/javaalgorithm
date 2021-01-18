package com.tong.string;

import org.junit.Test;

import java.util.Date;

/**
 * Created by HappyTong
 * Date on 2021/1/14 22:13
 */
public class DateTimeTest {
    @Test
    public void test1(){
        System.out.println(System.currentTimeMillis());
    }
    // Date类
    @Test
    public void test2(){
        Date date1 = new Date();
        System.out.println(date1.toString());
        java.sql.Date date = new java.sql.Date(date1.getTime());
        System.out.println(date);
//        java.sql.Date date = new java.sql.Date(1610634330802L);
//        System.out.println(date);
    }
}
