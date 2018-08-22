package com.yxw.shop.service;

import com.yxw.shop.modal.Category;
import com.yxw.shop.modal.Orders;
import com.yxw.shop.modal.PageBean;
import com.yxw.shop.modal.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Yan on 2018/7/18.
 */
public interface ProductService {
    //找热门商品
    public List<Product>  findByHotProduct() throws SQLException;

    //找最新商品
    public List<Product>  findByNewProduct() throws SQLException;

    //找商品类别
    public List<Category>  findByCategory() throws SQLException;

    //商品类别分页
    public PageBean findProductByCid(String cid, Integer currentPage, Integer pageSize) throws SQLException;

    //查询商品通过pid
     public Product findProductByPid(String pid) throws SQLException;

    //查询商品通过pid
    public Integer deleteByPid(String pid) throws SQLException;

    public void submitOrders(Orders orders);

    public void updateOrders(Orders orders);

    public  void updateOrderState(String r6_order);

   public List<Orders> findAllOrders(String uid);

    //订单分页
    public PageBean findPageAllOrders(String uid,Integer currentPage, Integer pageSize) throws SQLException;

    public Integer getOrderPageTotal(String uid);

    public  List<Map<String,Object>> findAllOrderItemByOid(String oid);


}
