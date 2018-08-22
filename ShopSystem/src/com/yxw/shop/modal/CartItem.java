package com.yxw.shop.modal;

/**
 * Created by Yan on 2018/7/19.
 */
public class CartItem {
    private Product product;//商品
    private double productTotalPrice;//价格*数量
    private Integer number;//数量

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(double productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
