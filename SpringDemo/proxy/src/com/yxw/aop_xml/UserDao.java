package com.yxw.aop_xml;


/**
 * 1.面对过程的分离
 * 2、对象化分离
 * Created by Yan on 2018/7/29.
 */
public class UserDao implements IUserDao {

    public void save(){
        System.out.println("保存........");
    }
}
