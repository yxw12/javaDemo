package com.yxw.shop.modal;

import java.util.List;

/**
 * Created by Yan on 2018/7/18.
 */
public class PageBean<T> {
    private Integer currentNumber;//当前页
    private Integer pageSize;//每页显示数量
    private Integer totalPage;//总页数
    private Integer totalNumber;//商品总数量
    private List<T> list;

    public Integer getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(Integer currentNumber) {
        this.currentNumber = currentNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
