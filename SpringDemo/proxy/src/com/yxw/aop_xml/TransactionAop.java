package com.yxw.aop_xml;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 重复代码
 * Created by Yan on 2018/7/29.
 */

public class TransactionAop {

    public void beginTransaction(JoinPoint joinPoint){
        System.out.println("对象名："+joinPoint.getThis());
        System.out.println("目标方法："+joinPoint.getSignature().getName());
        System.out.println("【前置通知】+开启事务......");
    }

    public void commit(){
        System.out.println("【后置通知】+提交事务.......");
    }

    public void AfterReturning(JoinPoint joinPoint){
        System.out.println("【返回后通知】.......");
        System.out.println(joinPoint.getThis());
        System.out.println(joinPoint.getSignature().getName());
    }

    public void AfterThrowing(){
        System.out.println("【异常通知】.......");
    }

    public void Around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("【环绕开始】.......");
        point.proceed();
        System.out.println("【环绕结束】.......");
    }
}
