package com.yxw.aop;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * Created by Yan on 2018/8/1.
 */
@Component
@Aspect
public class TxAop {
    @AfterReturning(value = "execution(* com.yxw.service.impl.UserServiceImpl.*(..))",returning = "objects")
    public void after(JoinPoint joinPoint, Object[] objects){
        System.out.println(joinPoint.getSignature().getName());
        Connection conn=(Connection) objects[2];
        PreparedStatement ps=(PreparedStatement) objects[1];
        ResultSet rs=(ResultSet) objects[0];
        try{
            rs.close();
            ps.close();
            conn.close();
            System.out.println("事务关闭啦.....");
        }catch (Exception e){

        }

    }
}
