package com.bdqn.controller;

import com.bdqn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(path = "student/login")
    public String login(String username,String password){

        if(studentService.login(username,password)){
            return "welcome";
        }
        return "login";
    }
}
