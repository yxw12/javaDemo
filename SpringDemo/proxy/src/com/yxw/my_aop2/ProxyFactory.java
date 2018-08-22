package com.yxw.my_aop2;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂
 * Created by Yan on 2018/7/29.
 */
public class ProxyFactory {
    /**
     * 生成代理对象
     * @param target  目标对象
     * @param aop   给目标对象动态注入的重复的代码（关注点代码）
     * @return
     */
    public Object getProxyInstance(final Object target,final TransactionAop aop){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        aop.beginTransaction();//执行重复的代码

                        Object result = method.invoke(target, objects);//执行目标对象方法

                        aop.commit();//执行重复的代码
                        return result;
                    }
                }
        );
    }
}
