package com.cn.yxw.modules.cities.service;

import com.cn.yxw.modules.cities.model.City;
import com.cn.yxw.modules.cities.model.Place;

import java.util.List;

/**
 * Created by Yan on 2018/7/16.
 */
public interface CityService {
    public List<City> getCityList();

    public List<Place> findPlaceByCityId(Integer cityId);

}
