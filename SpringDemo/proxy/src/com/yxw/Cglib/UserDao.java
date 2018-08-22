package com.yxw.Cglib;

/**
 * 目标对象
 * Created by Yan on 2018/7/29.
 */
public class UserDao {

    public void save() {
        System.out.println("代理模式：保存......");
    }

    public void find() {
        System.out.println("代理模式：查询......");
    }
}
