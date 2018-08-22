package com.yxw.modules.aop.txaop;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * Created by Yan on 2018/7/31.
 */
@Component("aop")
@Aspect
public class TxAop {
    @Pointcut(value = "execution(* com.yxw.modules.aop.dao.UserDao.save(..))&&args(name)",argNames = "name")
    public void pointcut_(String name){

    }

    @Before("execution(* com.yxw.modules.aop.dao.UserDao.query(..))")
    public void TxBefore1( ){
        System.out.println("开启事务.....");
    }


    @Before(value = "pointcut_(name)")
    public void TxBefore(String name){
        System.out.println("前置通知....."+name);
    }

  /*  @After("pointcut_()")
    public void TxAfter(){
        System.out.println("后置通知........");
    }*/

    @AfterReturning(value = "pointcut_(name)",returning = "a")
    public void TxAfterReturing(JoinPoint joinPoint,int a,String name){
        System.out.println("返回后通知........."+name);
        Object aThis = joinPoint.getThis();
        System.out.println(aThis);
        String name1 = joinPoint.getSignature().getName();
        System.out.println(name1);
        System.out.println(a);
    }

  /*  @Around("pointcut_(name)")
    public void TxRound(ProceedingJoinPoint point,String name) throws Throwable {
        System.out.println("环绕前通知........."+name);
        point.proceed();
        System.out.println("环绕后通知........."+name);
    }*/


}
