package com.yxw.shop.service;

import com.yxw.shop.modal.Category;
import com.yxw.shop.modal.Orders;
import com.yxw.shop.modal.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by Yan on 2018/7/22.
 */
public interface AdminService {
    public List<Category> findByCategory();

    public  void saveProduct(Product product);

   public List<Product> findAllProduct();

    public  void deleteByPid(String pid);

    public  Product selectByPid(String pid);

    public void updateProduct(Product product);

    public void addCategory(Category category);

    public void deleteByCid(String cid);

    public Category selectByCid(String cid);

    public void editCategory(Category category);

    public List<Orders> findAllOrders();

    public List<Map<String, Object>> findOrderInfoByOid(String oid);
}
