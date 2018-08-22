package com.yxw.test;

import com.yxw.modal.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Yan on 2018/7/26.
 */
public class test {
    //空参构造创建
    @Test
    public void funcTest(){
        //1.获取容器路径
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-config.xml");
        //2.像容器要user对象
        User user = (User) ac.getBean("user");
        //3.输出user对象
        System.out.println(user.toString());
    }
    //静态工厂创建
    @Test
    public void funcTest1(){
        //1.获取容器路径
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-config.xml");
        //2.像容器要user对象
        User user = (User) ac.getBean("user2");
        //3.输出user对象
        System.out.println(user.toString());
    }

    //实例工厂创建
    @Test
    public void funcTest3(){
        //1.获取容器路径
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-config.xml");
        //2.像容器要user对象
        User user = (User) ac.getBean("user3");
        //3.输出user对象
        System.out.println(user.toString());
    }

    //scope属性:singleton单例
    //scope属性:prorotype多例
    @Test
    public void funcTest4(){
        //1.获取容器路径
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-config.xml");
        //2.像容器要user对象
        User user = (User) ac.getBean("user3");
        User user1 = (User) ac.getBean("user3");
        User user2 = (User) ac.getBean("user3");
        //3.输出user对象
        System.out.println(user==user1);//单例true
                                        //多例false
    }

    //测试生命周期方法
    @Test
    public void funcTest5(){
        //1.获取容器路径
        AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-config.xml");
        //2.像容器要user对象
        User user = (User) ac.getBean("user");
        //3.输出user对象
        System.out.println(user);
        //关闭容器触发销毁方法
        ac.close();
    }
}
