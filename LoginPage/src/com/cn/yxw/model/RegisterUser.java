package com.cn.yxw.model;

/**
 * Created by Yan on 2018/7/11.
 */
public class RegisterUser {
    private Integer RuserId;
    private String Rusername;
    private String Rpassword;

    public Integer getRuserId() {
        return RuserId;
    }

    public void setRuserId(Integer ruserId) {
        RuserId = ruserId;
    }

    public String getRusername() {
        return Rusername;
    }

    public void setRusername(String rusername) {
        Rusername = rusername;
    }

    public String getRpassword() {
        return Rpassword;
    }

    public void setRpassword(String rpassword) {
        Rpassword = rpassword;
    }

}
