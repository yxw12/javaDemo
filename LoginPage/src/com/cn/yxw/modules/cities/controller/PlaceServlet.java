package com.cn.yxw.modules.cities.controller;

import com.cn.yxw.modules.cities.model.Place;
import com.cn.yxw.modules.cities.service.CityService;
import com.cn.yxw.modules.cities.service.Impl.CityServiceImpl;
import com.cn.yxw.service.Impl.UserServiceImpl;
import com.cn.yxw.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yan on 2018/7/16.
 */
public class PlaceServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cityidStr = request.getParameter("cityId");
        Integer cityid = Integer.parseInt(cityidStr);
        PrintWriter out = null;
        try{
            out = response.getWriter();
        }catch(Exception e){
            e.printStackTrace();
        }
     //   Integer cityid = 1;
        JSONArray cityArray = new JSONArray();
        JSONObject member = null;
        CityService cityService=new CityServiceImpl();
        try{
            //根据城市的Id 来查找城市下所有的地方
            List<Place> cityList = cityService.findPlaceByCityId(cityid);
            for(Place place: cityList){
                member = new JSONObject();
                member.put("placeId", place.getPlaceId());
                member.put("placeName", place.getPlaceName());
                cityArray.add(member);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        out.print(cityArray.toString());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
