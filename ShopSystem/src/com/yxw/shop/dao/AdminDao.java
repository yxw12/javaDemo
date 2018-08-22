package com.yxw.shop.dao;

import com.yxw.shop.modal.Category;
import com.yxw.shop.modal.Orders;
import com.yxw.shop.modal.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Yan on 2018/7/22.
 */
public interface AdminDao {
    public List<Category> findByCategory() throws SQLException;

    public  void saveProduct(Product product) throws SQLException;

   public List<Product> findAllProduct() throws SQLException;

    public  void deleteByPid(String pid) throws SQLException;

    public Product selectByPid(String pid) throws SQLException;

    public void updateProduct(Product product) throws SQLException;

    public void addCategory(Category category) throws SQLException;

    public void deleteByCid(String cid) throws SQLException;

    public Category selectByCid(String cid) throws SQLException;

    public void editCategory(Category category) throws SQLException;

    public List<Orders> findAllOrders() throws SQLException;

    public List<Map<String, Object>> findOrderInfoByOid(String oid) throws SQLException;
}
