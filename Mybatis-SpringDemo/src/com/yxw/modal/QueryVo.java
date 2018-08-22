package com.yxw.modal;

import java.util.List;

/**
 * 包装类
 * Created by Yan on 2018/8/4.
 */
public class QueryVo {
    private Product product;
    private Integer[] ids;
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
