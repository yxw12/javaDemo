package com.yxw.modal;

/**
 * Created by Yan on 2018/8/5.
 */
public class MyException extends Exception{
    // 异常信息
    private String message;

    public MyException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
