package com.cn.yxw.controller;

import com.cn.yxw.model.Product;
import com.cn.yxw.service.Impl.UserServiceImpl;
import com.cn.yxw.service.UserService;
import net.sf.json.JSONArray;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Yan on 2018/7/12.
 */
@WebServlet(name = "ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String word=request.getParameter("word");
        UserService userService = new UserServiceImpl();
        List<Product> products = userService.productFindByWord(word);

        List<Product> list=new ArrayList<Product>();
        for (int i=0;i<products.size();i++){
            Product p=new Product();
            p.setPid(products.get(i).getPid());
            p.setPname(products.get(i).getPname());
            p.setPinyin(products.get(i).getPinyin());
            list.add(p);
        }
//        request.setAttribute("products",products);
    //    request.getRequestDispatcher("ces/product.jsp").forward(request,response);
          JSONArray list1=JSONArray.fromObject(list);
   //     System.out.println(list1.toString());
          response.getWriter().print(list1);


    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
