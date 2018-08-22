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
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Created by Yan on 2018/7/9.
 */
@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId=request.getParameter("userId");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String gender=request.getParameter("optionsRadios");
        String birthday=request.getParameter("birthday");
        String address=request.getParameter("address");
            //把参数转换成相应的数据类型
            java.util.Date data=null;
            Integer gende1r=null;
            Integer userIdStr=null;
            if(gender!=null){
                gende1r=new Integer(gender);
            }
            if(birthday!=null){
                try {
                    data=new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            if(userId!=null){
                userIdStr=new Integer(userId);
            }
            User u=new User();
            u.setUsername(username);
            u.setPassword(password);
            u.setGender(gende1r);
            u.setBirthday(data);
            u.setAddress(address);
            u.setUserId(userIdStr);

            UserService userService=new UserServiceImpl();
            userService.updateUser(u);
            String path=request.getContextPath();
            response.sendRedirect(path+"/PageServlet");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
