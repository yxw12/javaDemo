package com.cn.yxw.controller;


import com.cn.yxw.model.RegisterUser;
import com.cn.yxw.service.Impl.UserServiceImpl;
import com.cn.yxw.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by Yan on 2018/7/9.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取用户名
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //查询是否存在
        UserService userService=new UserServiceImpl();
        RegisterUser user=userService.getUserByNameAndPass(username,password);
        boolean bool=false;
        if(user!=null && user.getRuserId()!=null){
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
    //        String path = request.getContextPath();
    //        response.sendRedirect(path+"/PageServlet");
    //      response.getWriter().print("登录成功！");
            bool=true;
        }else{
            bool=false;
      //      response.getWriter().print(bool);
       //   request.setAttribute("errorMessage","用户名或密码错误!");
        //   request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        response.getWriter().print(bool);
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
