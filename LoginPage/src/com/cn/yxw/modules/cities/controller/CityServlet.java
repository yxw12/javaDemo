package com.cn.yxw.modules.cities.controller;

import com.cn.yxw.modules.cities.model.City;
import com.cn.yxw.modules.cities.service.CityService;
import com.cn.yxw.modules.cities.service.Impl.CityServiceImpl;
import com.cn.yxw.service.Impl.UserServiceImpl;
import com.cn.yxw.service.UserService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yan on 2018/7/16.
 */
public class CityServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         CityService cityService=new CityServiceImpl();
         List<City> city=cityService.getCityList();
         List<City> list=new ArrayList<City>();
        //对象转json数组
        for (int i=0;i<city.size();i++){
            City city1=new City();
            city1.setCityId(city.get(i).getCityId());
            city1.setCityName(city.get(i).getCityName());
            list.add(city1);
        }

        //    list.toString();
        JSONArray array = JSONArray.fromObject(list);
        //    JSONArray list1=JSONArray.fromObject(list);
        //   System.out.println("json:"+list1.toString());

        response.getWriter().print(array);
  //      request.setAttribute("city",city);
    //    request.setAttribute("city",city);
   //     request.getRequestDispatcher("ces/toInsert.jsp").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
