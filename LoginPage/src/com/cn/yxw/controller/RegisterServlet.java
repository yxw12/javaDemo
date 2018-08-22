package com.cn.yxw.controller;

import com.cn.yxw.service.Impl.UserServiceImpl;
import com.cn.yxw.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Yan on 2018/7/11.
 */
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPass = request.getParameter("comfpassword");
        UserService userService=new UserServiceImpl();
        if(password.equals(confirmPass)&& password!=null&&!password.equals("")){
            if(userService.registerUser(username,password)==1){
      //          response.getWriter().write("Register successfully!");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }
    }
}
