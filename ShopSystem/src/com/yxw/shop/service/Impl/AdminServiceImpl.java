package com.yxw.shop.service.Impl;

import com.yxw.shop.dao.AdminDao;
import com.yxw.shop.dao.Impl.AdminDaoImpl;
import com.yxw.shop.modal.Category;
import com.yxw.shop.modal.Orders;
import com.yxw.shop.modal.Product;
import com.yxw.shop.service.AdminService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Yan on 2018/7/22.
 */
public class AdminServiceImpl implements AdminService{
    AdminDao AdminDao=new AdminDaoImpl();
    @Override
    public List<Category> findByCategory() {
        try {
            return AdminDao.findByCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveProduct(Product product) {
        try {
             AdminDao.saveProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAllProduct() {
        List<Product> productList= null;
        try {
            productList = AdminDao.findAllProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void deleteByPid(String pid) {
        try {
            AdminDao.deleteByPid(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product selectByPid(String pid) {
        Product product= null;
        try {
            product = AdminDao.selectByPid(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        try {
            AdminDao.updateProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCategory(Category category) {
        try {
            AdminDao.addCategory(category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByCid(String cid) {
        try {
            AdminDao.deleteByCid(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category selectByCid(String cid) {
        Category category=null;
        try {
           category=AdminDao.selectByCid(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void editCategory(Category category) {
        try {
            AdminDao.editCategory(category);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Orders> findAllOrders() {
        List<Orders> ordersList= null;
        try {
            ordersList = AdminDao.findAllOrders();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordersList;
    }

    @Override
    public List<Map<String, Object>> findOrderInfoByOid(String oid) {
        List<Map<String, Object>> mapList= null;
        try {
            mapList = AdminDao.findOrderInfoByOid(oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapList;
    }
}
