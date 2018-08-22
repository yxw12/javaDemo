package com.yxw.aop_anno;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 重复代码
 * Created by Yan on 2018/7/29.
 */

@Component("aop")
@Aspect    //指定一个类为切面类
public class TransactionAop {

    //定义一个切入点表达式变量（后面使用这个切入点表达式的时候，直接引用方法名即可）
    @Pointcut("execution(* com.yxw.aop_anno.UserDao.*(..))")
    public void pointcut_(){

    }


   //【前置通知】+在执行业务方法，之前执行
    @Before("pointcut_()")
    public void beginTransaction(){
        System.out.println("【前置通知】+开启事务......");
    }

    //【后置通知】+在执行业务方法之后，执行
    @After("pointcut_()")
    public void commit(){
        System.out.println("【后置通知】+提交事务.......");
    }

    //【返回后通知】+在执行目标方法结束之后执行、出现异常不会执行
    @AfterReturning("pointcut_()")
    public void AfterReturning(){
        System.out.println("【返回后通知】.......");
    }

    //【异常通知】+在执行目标方法的时候出现异常执行
    @AfterThrowing("pointcut_()")
    public void AfterThrowing(){
        System.out.println("【异常通知】.......");
    }

    //【环绕通知】+会环绕目标方法执行
    @Around("pointcut_()")
    public void Around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("【环绕开始】.......");
        point.proceed();
        System.out.println("【环绕结束】.......");
    }
}
