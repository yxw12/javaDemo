package com.yxw.service.impl;

import com.yxw.dao.ProductDao;
import com.yxw.modal.Product;
import com.yxw.modal.QueryVo;
import com.yxw.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yan on 2018/8/4.
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Resource
    private ProductDao productDao;
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findProById(int pid) {
        return productDao.findProById(pid);
    }

    @Override
    public void updateProById(Product product) {
        productDao.updateProById(product);
    //    int i=1/0;
    }

    @Override
    public List<Product> queryitem(QueryVo queryVo) {
        return productDao.queryitem(queryVo);
    }

    @Override
    public void deleteitem(QueryVo queryVo) {
        productDao.deleteitem(queryVo);
    }

    @Override
    public void updatePros(QueryVo queryVo) {
        productDao.updatePros(queryVo);
    }
}
