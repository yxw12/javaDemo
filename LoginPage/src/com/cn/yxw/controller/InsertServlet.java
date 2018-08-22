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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yan on 2018/7/9.
 */
@WebServlet(name = "InsertServlet" )
public class InsertServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username=request.getParameter("username");//这个要跟前端的name对应
        String password=request.getParameter("password");
        String gender=request.getParameter("optionsRadios");
        String birthday=request.getParameter("birthday");
        String address=request.getParameter("cityId");
            //把参数转换成相应的数据类型
            Date date=new Date();
            if(birthday!=null && !birthday.equals("")){
               try {
                     date=sdf.parse(birthday);
               } catch (ParseException e) {
                    e.printStackTrace();
               }

            }
            User u=new User();
            u.setUsername(username);
            u.setPassword(password);
            if(null!=gender&&!gender.equals("")){
                u.setGender(Integer.valueOf(gender));
            }
            u.setBirthday(date);
            u.setAddress(address);

            UserService userService=new UserServiceImpl();
            userService.saveUser(u);
            String path=request.getContextPath();
            response.sendRedirect(path+"/PageServlet");
          //  response.getWriter().write("Insert data successfully!");//ajax里面的data
    }
}
