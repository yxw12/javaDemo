package com.cn.yxw.modules.cities.service.Impl;

import com.cn.yxw.modules.cities.dao.CityDao;
import com.cn.yxw.modules.cities.dao.Impl.CityDaoImpl;
import com.cn.yxw.modules.cities.model.City;
import com.cn.yxw.modules.cities.model.Place;
import com.cn.yxw.modules.cities.service.CityService;

import java.util.List;

/**
 * Created by Yan on 2018/7/16.
 */
public class CityServiceImpl implements CityService{
    CityDao CityDao=new CityDaoImpl();
    @Override
    public List<City> getCityList() {
        return CityDao.getCityList();
    }

    @Override
    public List<Place> findPlaceByCityId(Integer cityId) {
        return CityDao.findPlaceByCityId(cityId);
    }
}
