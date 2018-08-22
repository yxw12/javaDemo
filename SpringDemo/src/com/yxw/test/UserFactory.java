package com.yxw.test;

import com.yxw.modal.User;

/**
 * Created by Yan on 2018/7/26.
 */
public class UserFactory {
    public static User createUser(){
        System.out.println("静态工厂创建User");
        return new User();
    }

    public  User createUser1(){
        System.out.println("实例工厂创建User");
        return new User();
    }
}
