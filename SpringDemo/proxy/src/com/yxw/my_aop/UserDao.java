package com.yxw.my_aop;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 1.面对过程的分离
 * 2、对象化分离
 * Created by Yan on 2018/7/29.
 */
@Repository      //把对象加入IOC容器
public class UserDao {

    @Resource
   private TransactionAop aop;

    public void save(){
        aop.beginTransaction();
        System.out.println("保存........");
        aop.commit();
    }
}
