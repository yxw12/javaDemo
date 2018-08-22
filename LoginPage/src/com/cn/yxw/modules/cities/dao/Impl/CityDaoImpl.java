package com.cn.yxw.modules.cities.dao.Impl;

import com.cn.yxw.DButils;
import com.cn.yxw.modules.cities.dao.CityDao;
import com.cn.yxw.modules.cities.model.City;
import com.cn.yxw.modules.cities.model.Place;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yan on 2018/7/16.
 */
public class CityDaoImpl implements CityDao{
    /**
     * 根据城市id获取city名
     * @param cityId
     * @return
     */
    @Override
    public List<City> getCityList() {
        String sql="SELECT * FROM city";
        PreparedStatement pstmt=null;
        List<City> cityList=new ArrayList<City>();
        ResultSet rs = null;
        try {
            pstmt = DButils.getPstmt(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                City city = new City();
                Integer cityid=rs.getInt("cityid");
                String cityname=rs.getString("cityname");

                city.setCityId(cityid);
                city.setCityName(cityname);

                cityList.add(city);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DButils.closeQueryRes(rs);
        }
        return cityList;
    }

    @Override
    public List<Place> findPlaceByCityId(Integer cityId) {
        String sql="SELECT p.* FROM place p,city c WHERE p.`cityid`=c.`cityid` AND p.`cityid`=?";
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<Place> places = new ArrayList<Place>();
        try {
            pstmt=DButils.getPstmt(sql);
            pstmt.setInt(1,cityId);
            rs=pstmt.executeQuery();
            while (rs.next()){
                Place place1=new Place();
                Integer placeid = rs.getInt("placeid");
                String placename=rs.getString("placename");
                Integer cityid=rs.getInt("cityid");

                place1.setPlaceId(placeid);
                place1.setPlaceName(placename);
                place1.setCityId(cityid);

                places.add(place1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.closeQueryRes(rs);
        }

        return places;
    }
}
