package com.yxw.controller;

import com.yxw.modal.User;
import com.yxw.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Yan on 2018/7/27.
 */
@Controller("userServlet")
public class UserServlet {
    @Resource(name = "userService")
    private UserService userService;

    public List<User> findUserList() {
      return userService.findUserList();
    }
}

