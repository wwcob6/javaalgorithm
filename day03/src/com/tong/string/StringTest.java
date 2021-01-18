package com.tong.string;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Created by HappyTong
 * Date on 2021/1/12 21:53
 */
public class StringTest {
    @Test
    public void test1(){
        String str = "123ABC";
        String str1 = "123456";
        System.out.println(str.substring(1,3));
        System.out.println(str.charAt(1));
        System.out.println(str.equalsIgnoreCase(str1));
        System.out.println(str.replace('2', '3'));
    }
    @Test
    public void test2(){
        String s1 = "abc";
        String s2 = "abe";
        String str1 = "javaee";
        String str2 = "   javaee   ";
        System.out.println(s1.replace('a', 'c'));
        System.out.println(s2.replace("ab", "cd"));
    }
    @Test
    public void  test3(){
        String s1 = "abcde";
        char[] chars = s1.toCharArray();
        char[] chars1 = {'1', '2','3','4'};
        String s2 = new String(chars1);
        System.out.println(chars1);
        System.out.println(s2.toCharArray());
        byte[] bytes = s1.getBytes();
        System.out.println(Arrays.toString(bytes));
    }
}
