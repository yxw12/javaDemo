package com.bdqn.controller;

import com.bdqn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(path="user/addUser")
    public String addUser(String id, String username, String upassword){
        int result=userService.addUser(id,username,upassword);
        return "success";
    }
}
