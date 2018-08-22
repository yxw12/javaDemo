package com.yxw.dao;

import com.yxw.modal.Product;
import com.yxw.modal.QueryVo;

import java.util.List;

/**
 * Created by Yan on 2018/8/4.
 */
public interface ProductDao {
    List<Product> findAll();

    Product findProById(int pid);

    void updateProById(Product product);

    List<Product> queryitem(QueryVo queryVo);

    void deleteitem(QueryVo queryVo);

    void updatePros(QueryVo queryVo);
}
