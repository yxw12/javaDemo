package com.yxw.test;

import com.yxw.pojo.User;
import com.yxw.pojo.User_mysql;
import com.yxw.service.UserService;
import com.yxw.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yan on 2018/8/1.
 */
@Component
public class test {


    private static UserService userService;
    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void findAll(){
        new ClassPathXmlApplicationContext("spring-config.xml");
        List<User> userList = (List<User>)userService.findAll()[3];
        for (User user:userList) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void findByid(){

        new ClassPathXmlApplicationContext("spring-config.xml");
        User_mysql user = userService.findById(10);
            System.out.println(user.toString());
    }
}
