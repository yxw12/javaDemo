package com.yxw.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 代理工厂，给多个目标对象生成代理对象
 * Created by Yan on 2018/7/29.
 */
public class ProxyFactory {
    //接受一个目标对象
    private Object target;
    public ProxyFactory(Object target){
        this.target=target;
    }

    // 返回对目标对象（target）代理后的对象（proxy)
    public  Object getProxyInstance(){
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),//目标对象使用的类加载器
                target.getClass().getInterfaces(),//目标对象实现的所有接口
                new InvocationHandler() {        //执行代理对象方法时候触发
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        //获取当前方法的方法名
                        String methodName = method.getName();
                        //方法返回值
                        Object result=null;
                        if("find".equals(methodName)){
                            //直接调用目标对象方法
                              result=method.invoke(target,objects);
                        }else{
                            System.out.println("代理操作：开启事务。。。");
                            //执行目标对象方法
                            result=method.invoke(target,objects);

                            System.out.println("代理操作：提交事务。。。");
                        }

                        return result;
                    }
                }
        );

        return proxy;
    }

}
