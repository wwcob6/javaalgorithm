package com.tong.practice;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
* Error:
* Java虚拟机无法解决的严重问题.如JVM系统内部错误、资源耗尽
* 一般不编写代码处理
* Exception:
*
*
* */
public class Demo01Exception {

    /*public static void main(String[] args) {
        //栈溢出 main(args); java.lang.StackOverflowError
        //堆溢出 Integer[] arr = new Integer[1024*1024*1024]; java.lang.OutOfMemoryError
    }*/
    @Test
    public void test1() {
        String str = "123";
        str = "abc";
        try {
            int num =Integer.parseInt(str);
            System.out.println("try");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        int num = method();
        System.out.println(num);
    }
    public int method() {
        try{
            int[] arr = new int[10];
            System.out.println(arr[10]);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        } finally {
            System.out.println("无论如何先运行finally");
        }
    }

    @Test
    public void test3() {
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");
            fis = new FileInputStream(file);
            int data = fis.read();
            while (data != -1) {
                System.out.println((char) data);
                data = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
