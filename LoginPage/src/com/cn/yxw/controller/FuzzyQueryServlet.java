package com.cn.yxw.controller;

import com.cn.yxw.model.PageBean;
import com.cn.yxw.model.Product;
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
import java.util.List;

/**
 * Created by Yan on 2018/7/13.
 */
@WebServlet(name = "FuzzyQueryServlet")
public class FuzzyQueryServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 //       String word=request.getParameter("word");
 //       UserService userService = new UserServiceImpl();
 //       List<Product> pageBean = userService.productFindByWord(word);
  //      request.setAttribute("pageBean",pageBean);
  //      request.getRequestDispatcher("ces/tab.jsp").forward(request,response);
//        JSONArray list1=JSONArray.fromObject(list);
        //      response.getWriter().print(list1);

        // 1.获得分页参数
        String pageNumberStr=request.getParameter("pageNumber");
        String startDateStr=request.getParameter("startDate");
        String endDateStr=request.getParameter("endDate");
        String word=request.getParameter("word");
        if(pageNumberStr==null) pageNumberStr="1";
        Integer pageNumber = Integer.parseInt(pageNumberStr);
        try {
            Integer.parseInt(pageNumberStr);
        }catch (Exception e){

        }

        java.util.Date startDate=null;
        if(startDateStr!=null){
            try {
                startDate=new SimpleDateFormat("yyyy-MM-dd").parse(startDateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        java.util.Date endDate=null;
        if(startDateStr!=null){
            try {
                endDate=new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    //    Integer pageNumber=0;
        Integer pageSize=9;
        //     Integer pageSize=Integer.parseInt(request.getParameter("pageSize"));
        // 2.通知service，查询所有用户
        UserService userService=new UserServiceImpl();
        PageBean<User> pageBean = userService.FuzzyOnefindAll(word,startDate,endDate,pageNumber,pageSize);
        //3.选择jsp
        //3.1将查询结果存放在request作用域中
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("startDate",startDateStr);
        request.setAttribute("endDate",endDateStr);
        request.setAttribute("word",word);
        //3.2请求转发
        request.getRequestDispatcher("ces/toFuzzyQuery.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
