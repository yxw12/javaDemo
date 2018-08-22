package com.yxw.staticProxy;

/**
 * 目标对象
 * Created by Yan on 2018/7/29.
 */
public class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("代理模式：保存......");
    }

    @Override
    public void find() {
        System.out.println("代理模式：查询......");
    }
}
