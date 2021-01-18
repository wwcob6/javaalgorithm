package com.tong.string;

import org.junit.Test;

/**
 * Created by HappyTong
 * Date on 2021/1/14 17:03
 */
public class StringBufferBuilderTest {
    @Test
    public void test1(){
        StringBuffer stringBuffer = new StringBuffer("abc");
        stringBuffer.append(false);
        /*System.out.println(stringBuffer.charAt(4));
        System.out.println(stringBuffer.deleteCharAt(2));
        System.out.println(stringBuffer.indexOf("ab"));
        System.out.println(stringBuffer.insert(2, "cdef"));
        System.out.println(stringBuffer.replace(0, 6, "hahah~"));*/
        System.out.println(stringBuffer.reverse());

    }

    @Test
    public void test2(){
        StringBuilder stringBuilder = new StringBuilder("abc");
        stringBuilder.setCharAt(0, 'w');
        System.out.println(stringBuilder);
    }
}
