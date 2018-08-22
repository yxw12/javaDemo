package com.yxw.shop.dao;

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
public interface ProductDao {
    //找热门商品
    public List<Product> findByHotProduct() throws SQLException;

    //找最新商品
    public List<Product>  findByNewProduct() throws SQLException;

    //找商品类别
    public List<Category>  findByCategory() throws SQLException;

    //分类商品总数
    public  Integer getTotal(String cid) throws SQLException;

    public  List<Product> findProductByPage(String cid, Integer index, Integer pageSize) throws SQLException;

    public  Product findProductByPid(String pid) throws SQLException;

    public  Integer deleteByPid(String pid) throws SQLException;

    public  void insertOrders(Orders orders) throws SQLException;

    public void insertOrderitem(Orders orders) throws SQLException;

    public void updateOrders(Orders orders) throws SQLException;

    public void updateOrderState(String r6_order) throws SQLException;

    public  List<Orders> findAllOrders(String uid) throws SQLException;

    public List<Orders> findPageAllOrders(String uid,Integer index, Integer pageSize) throws SQLException;

    public  List<Map<String,Object>> findAllOrderItemByOid(String oid) throws SQLException;

    public Integer getOrderPageTotal(String uid) throws SQLException;

}
