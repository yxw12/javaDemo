package com.yxw.controller;

import com.yxw.modal.User;
import com.yxw.service.UserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Yan on 2018/8/2.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/findById")
    public String findUser(String name,String password, Model model){
        int i = userService.findUser(name,password);
        if(i>0){
            List<User> userList = userService.findAllUsers();
            model.addAttribute("name",name);
            model.addAttribute("userList",userList);
            return "success";
        }else {
            return "index";
        }
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(int id, Model model){
        userService.deleteUser(id);
        List<User> userList = userService.findAllUsers();
        model.addAttribute("userList",userList);
        return "success";
    }
    @RequestMapping("/findOrdersByUid")
    public String findOrdersByUid(int uid,Model model){
        List<User> userList = userService.findOrdersByUid(uid);
        model.addAttribute("users",userList);
        return "order";
    }

    @RequestMapping("/updateUser")
    public String updateUser(int uid, String username, String password, String sex, String address, Model model) throws ParseException {
        User user=new User();
        user.setUid(uid);
        user.setSex(sex);
        user.setAddress(address);
   //     user.setBirthday(birthday);
        user.setUsername(username);
        user.setPassword(password);
        userService.updateUser(user);
        List<User> userList = userService.findAllUsers();
        model.addAttribute("userList",userList);
        return "success";
    }
    @RequestMapping("/findUserById")
    public String findUserById(int uid,Model model) {
        User user = userService.findUserById(uid);
        model.addAttribute("user",user);
        return "edit";
}

}
