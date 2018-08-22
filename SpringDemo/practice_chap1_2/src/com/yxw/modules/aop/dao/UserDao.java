package com.yxw.modules.aop.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by Yan on 2018/7/31.
 */
@Repository
public class UserDao {

    public int save(String name){
        System.out.println("正在保存。。。。。");
        return 1;
    }

    public void query() {
        System.out.println("查询用户......");
    }
}
