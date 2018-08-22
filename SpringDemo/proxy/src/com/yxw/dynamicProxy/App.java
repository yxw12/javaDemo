package com.yxw.dynamicProxy;

/**
 * Created by Yan on 2018/7/29.
 */
public class App {
    public static void main(String[] args) {
        //目标对象
        IUserDao target=new UserDao();
        //代理对象
        IUserDao proxy= (IUserDao) new ProxyFactory(target).getProxyInstance();
        //执行代理对象的方法
    //    proxy.save();

        proxy.find();
    }
}
