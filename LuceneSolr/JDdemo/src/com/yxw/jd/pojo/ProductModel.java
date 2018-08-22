package com.yxw.jd.pojo;

import java.util.Date;

/**
 * Created by Yan on 2018/8/9.
 */
public class ProductModel {
    //商品编号
    private String pid;
    //商品名称
    private String name;
    //商品分类
    private int catalog;
    //商品分类名称
    private String catalog_name;
    //价格
    private float price;
    //数量
    private int number;
    //商品描述
    private String description;
    //图片名称
    private String picture;
    //上架时间
    private Date Release_time;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCatalog() {
        return catalog;
    }

    public void setCatalog(int catalog) {
        this.catalog = catalog;
    }

    public String getCatalog_name() {
        return catalog_name;
    }

    public void setCatalog_name(String catalog_name) {
        this.catalog_name = catalog_name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getRelease_time() {
        return Release_time;
    }

    public void setRelease_time(Date release_time) {
        Release_time = release_time;
    }
}
