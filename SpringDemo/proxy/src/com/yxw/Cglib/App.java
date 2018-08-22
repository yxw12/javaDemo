package com.yxw.Cglib;

/**
 * Created by Yan on 2018/7/29.
 */
public class App {
    public static void main(String[] args) {
        //目标对象
        UserDao target=new UserDao();
        System.out.println("目标对象："+target.getClass());//class com.yxw.Cglib.UserDao
        //代理对象
        UserDao proxy= (UserDao) new ProxyFactory(target).getProxyInstance();
        //执行代理对象的方法
    //    proxy.save();
        System.out.println("代理对象："+proxy.getClass());//class com.yxw.Cglib.UserDao$$EnhancerByCGLIB$$a23b1098
        proxy.save();
    }
}
