package com.yxw.staticProxy;

/**
 * Created by Yan on 2018/7/29.
 */
public class App {
    public static void main(String[] args) {
        //代理对象
        IUserDao traget=new UserDaoProxy();
        //执行代理对象的方法
        traget.save();

        traget.find();
    }
}
