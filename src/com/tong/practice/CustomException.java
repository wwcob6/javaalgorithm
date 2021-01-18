package com.tong.practice;

public class CustomException extends RuntimeException{
    // 自定义异常
    static final long serialVersionUID = -7034897190745766939L;

    public CustomException(){

    }

    public CustomException(String msg){
        super(msg);
    }
}
