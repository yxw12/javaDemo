package com.cn.yxw.modules.cities.dao;

import com.cn.yxw.modules.cities.model.City;
import com.cn.yxw.modules.cities.model.Place;

import java.util.List;

/**
 * Created by Yan on 2018/7/16.
 */
public interface CityDao {
    public List<City> getCityList();

    public List<Place> findPlaceByCityId(Integer cityId);
}
