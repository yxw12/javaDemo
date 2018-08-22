package com.yxw.aop_anno;

import org.springframework.stereotype.Repository;

/**
 * Created by Yan on 2018/7/29.
 */
@Repository
public class OrderDao {
    public void save(){
        System.out.println("保存订单........");
    }
}
