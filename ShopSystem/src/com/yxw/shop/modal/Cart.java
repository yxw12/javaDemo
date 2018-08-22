package com.yxw.shop.modal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yan on 2018/7/19.
 */
public class Cart {
    //该购物车中存储的n个购物项
    private Map<String,CartItem> cartItemMap=new HashMap<String, CartItem>();
    //购物车中总价
    private double cartTotal;

    public Map<String, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<String, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(double cartTotal) {
        this.cartTotal = cartTotal;
    }
}
