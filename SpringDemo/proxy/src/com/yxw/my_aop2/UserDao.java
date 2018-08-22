package com.yxw.my_aop2;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 1.面对过程的分离
 * 2、对象化分离
 * Created by Yan on 2018/7/29.
 */
@Repository      //把对象加入IOC容器
public class UserDao implements IUserDao{

    public void save(){
        System.out.println("保存........");
    }
}
