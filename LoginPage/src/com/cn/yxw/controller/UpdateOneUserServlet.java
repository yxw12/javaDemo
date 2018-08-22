package com.cn.yxw.controller;

import com.cn.yxw.model.User;
import com.cn.yxw.service.Impl.UserServiceImpl;
import com.cn.yxw.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created by Yan on 2018/7/9.
 */
@WebServlet(name = "UpdateOneUserServlet")
public class UpdateOneUserServlet extends HttpServlet{
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String userIdStr=request.getParameter("userId");
            Integer userId=null;
            if(userIdStr!=null){
                userId=new Integer(userIdStr);
            }
            UserService userService=new UserServiceImpl();
            User user = userService.getUserById(userId);
            request.setAttribute("user",user);
            request.getRequestDispatcher("/ces/toUpdate.jsp").forward(request,response);
        }
    }

