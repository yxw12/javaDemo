package com.cn.yxw.controller;

import com.cn.yxw.model.PageBean;
import com.cn.yxw.model.Product;
import com.cn.yxw.model.User;
import com.cn.yxw.service.Impl.UserServiceImpl;
import com.cn.yxw.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yan on 2018/7/13.
 */
@WebServlet(name="ajaxPageServlet" )
public class ajaxPageServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获得分页参数
/*        String pageNumberStr=request.getParameter("pageNumber");
        Integer pageSize=Integer.parseInt(request.getParameter("pageSize"));
        if(pageNumberStr==null) pageNumberStr="1";
        Integer pageNumber = Integer.parseInt(pageNumberStr);
        try {
            Integer.parseInt(pageNumberStr);
        }catch (Exception e){

        }
        */
        Integer pageSize=4;
        Integer pageNumber=1;
        UserService userService=new UserServiceImpl();
        PageBean<User> pageBean = userService.findAll(pageNumber,pageSize);
        List<PageBean> list=new ArrayList<PageBean>();
        for (int i=0;i<pageBean.getData().size();i++){
            PageBean p=new PageBean(pageNumber,pageSize,pageBean.getTotalRecord());
            p.setPageNumber(pageBean.getPageNumber());
            p.setPageSize(pageBean.getPageSize());
            p.setTotalPage(pageBean.getTotalPage());
            p.setTotalRecord(pageBean.getTotalRecord());
            p.setData(pageBean.getData());
            list.add(p);
        }

    //    list.toString();
        JSONArray array = JSONArray.fromObject(list.toArray());
    //    JSONArray list1=JSONArray.fromObject(list);
     //   System.out.println("json:"+list1.toString());

        response.getWriter().print(array);

        //3.选择jsp
        //3.1将查询结果存放在request作用域中
  //      request.setAttribute("pageBean",pageBean);
        //3.2请求转发
  //      request.getRequestDispatcher("ces/tab.jsp").forward(request,response);
    }
}
