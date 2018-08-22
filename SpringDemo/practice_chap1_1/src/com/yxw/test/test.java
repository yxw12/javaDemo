package com.yxw.test;

import com.yxw.controller.UserServlet;
import com.yxw.modal.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yan on 2018/7/28.
 */
@Component
public class test {
    //test类 加 static + set 方法 + @Component

    private static UserServlet userServlet;

    @Resource
    public void setUserServlet(UserServlet userServlet) {
        this.userServlet = userServlet;
    }

    @Test
    public void test(){
        new ClassPathXmlApplicationContext("spring-config.xml");
 //       UserServlet userServlet = ac.getBean("userServlet", UserServlet.class);
        System.out.println(userServlet);
        List<User> listuser= userServlet.findUserList();
        for (User user : listuser) {
            System.out.println(user.toString());

        }
    }


}
