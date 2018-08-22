package com.cn.yxw.modules.cities.model;

/**
 * Created by Yan on 2018/7/16.
 */
public class Place {
    private Integer placeId;
    private String placeName;
    private Integer cityId;

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Place(){}

    public Place(Integer placeId, String placeName, Integer cityId) {
        this.placeId = placeId;
        this.placeName = placeName;
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeId=" + placeId +
                ", placeName='" + placeName + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
