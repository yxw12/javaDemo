package com.ht.servlet;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  username = request.getParameter("username");
        List<Person> list=new ArrayList<Person>();

        for (int i=0;i<4;i++){
            Person p=new Person();
            p.setId(1);
            p.setAge(20);
            p.setName("huangtao"+i);
            list.add(p);
        }
            //JSONObject object=JSONObject.fromObject(p);
//        response.getWriter().print(object.toString());
        JSONArray list1=JSONArray.fromObject(list);
        response.getWriter().print(list1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
