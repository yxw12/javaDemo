package com.yxw.my_aop2;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * 重复代码
 * Created by Yan on 2018/7/29.
 */
/*@Component("aop")*/
public class TransactionAop {
    public void beginTransaction(){
        System.out.println("开启事务......");
    }

    public void commit(){
        System.out.println("提交事务.......");
    }

}
