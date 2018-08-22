package com.yxw.injection;

import com.yxw.modal.User;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Yan on 2018/7/26.
 */
public class DemoTest {
    @Test
    public void funcTest5(){
        //1.获取容器路径
        AbstractApplicationContext ac=new ClassPathXmlApplicationContext("com/yxw/injection/spring-config.xml");
        //2.像容器要user对象
        User user = (User) ac.getBean("user");
        //3.输出user对象
        System.out.println(user);


    }

    @Test
    public void funcTest2(){
        //1.获取容器路径
        AbstractApplicationContext ac=new ClassPathXmlApplicationContext("com/yxw/injection/spring-config.xml");
        //2.像容器要user对象
        User user = (User) ac.getBean("user4");
        //3.输出user对象
        System.out.println(user);
    }

    @Test
    public void funcTest3(){
        //1.获取容器路径
        AbstractApplicationContext ac=new ClassPathXmlApplicationContext("com/yxw/injection/spring-config.xml");
        //2.像容器要collectionBean对象
        CollectionBean collectionBean = (CollectionBean) ac.getBean("cb");
        //3.输出collectionBean对象
        System.out.println(collectionBean);
    }
}
