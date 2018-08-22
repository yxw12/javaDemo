package com.yxw.shop.service.Impl;

import com.yxw.shop.dao.Impl.ProductDaoImpl;
import com.yxw.shop.dao.ProductDao;
import com.yxw.shop.modal.Category;
import com.yxw.shop.modal.Orders;
import com.yxw.shop.modal.PageBean;
import com.yxw.shop.modal.Product;
import com.yxw.shop.service.ProductService;
import com.yxw.shop.utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Yan on 2018/7/18.
 */
public class ProductServiceImpl implements ProductService{
    ProductDao ProductDao = new ProductDaoImpl();

    /**
     * 找热门商品
     * @return
     */
    @Override
    public List<Product> findByHotProduct() throws SQLException {
        return ProductDao.findByHotProduct();
    }

    /**
     * 查找最新商品
     * @return
     */
    @Override
    public List<Product> findByNewProduct() throws SQLException {
        return ProductDao.findByNewProduct();
    }

    /**
     * 查找商品类别
     * @return
     * @throws SQLException
     */
    @Override
    public List<Category> findByCategory() throws SQLException {
        return ProductDao.findByCategory();
    }

    /**
     * 商品类别分页
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageBean findProductByCid(String cid, Integer currentPage, Integer pageSize) throws SQLException {
        PageBean<Product> pageBean = new PageBean<Product>();
        //查询总数量
        Integer totalNumber = ProductDao.getTotal(cid);
        //封装总页数
        Integer totalPage = (totalNumber+pageSize-1)/pageSize;

        pageBean.setCurrentNumber(currentPage);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalNumber(totalNumber);
        pageBean.setTotalPage(totalPage);

        //当前页显示数据
        //select * from product where cid=? limit ?,?
        //当前页和起始索引index的关系
        Integer index = (currentPage-1)*pageSize;
        List<Product> list = ProductDao.findProductByPage(cid,index,pageSize);
        pageBean.setList(list);

        return pageBean;
    }

    /**
     * 查询商品通过pid
     * @param pid
     * @return
     */
    @Override
    public Product findProductByPid(String pid) throws SQLException {
        return ProductDao.findProductByPid(pid);
    }

    /**
     * 根据pid删除商品
     * @param pid
     * @return
     * @throws SQLException
     */
    @Override
    public Integer deleteByPid(String pid) throws SQLException {
        return ProductDao.deleteByPid(pid);
    }

    /**
     * 提交订单 将订单的数据和订单项的数据存储到数据库中
     * @param orders
     */
    @Override
    public void submitOrders(Orders orders) {
        try {
            //开启事务
            DataSourceUtils.startTransaction();
            ProductDao.insertOrders(orders);
            ProductDao.insertOrderitem(orders);

        } catch (SQLException e) {
            try {
                //回滚事务
                DataSourceUtils.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                //提交事务
                DataSourceUtils.commitAndRelease();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 更新订单表
     * @param orders
     * @return
     */
    @Override
    public void updateOrders(Orders orders) {
        try {
            ProductDao.updateOrders(orders);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 改变商品支付状态
     * @param r6_order
     */
    @Override
    public void updateOrderState(String r6_order) {
        try {
            ProductDao.updateOrderState(r6_order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Orders> findAllOrders(String uid) {
        List<Orders> ordersList= null;
        try {
            ordersList = ProductDao.findAllOrders(uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordersList;
    }

    /**
     * 订单分页
     * @param uid
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageBean findPageAllOrders(String uid, Integer currentPage, Integer pageSize){
        PageBean<Orders> pageBean = new PageBean<Orders>();
        //查询总数量
        Integer totalNumber = null;
        try {
            totalNumber = ProductDao.getOrderPageTotal(uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //封装总页数
        Integer totalPage = (totalNumber+pageSize-1)/pageSize;

        pageBean.setCurrentNumber(currentPage);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalNumber(totalNumber);
        pageBean.setTotalPage(totalPage);

        //当前页显示数据
        //select * from product where cid=? limit ?,?
        //当前页和起始索引index的关系
        Integer index = (currentPage-1)*pageSize;
        List<Orders> list = null;
        try {
            list = ProductDao.findPageAllOrders(uid,index,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pageBean.setList(list);

        return pageBean;
    }

    @Override
    public Integer getOrderPageTotal(String uid){
        Integer number= null;
        try {
            number = ProductDao.getOrderPageTotal(uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number;
    }

    @Override
    public List<Map<String, Object>> findAllOrderItemByOid(String oid) {
        List<Map<String, Object>> mapList= null;
        try {
            mapList = ProductDao.findAllOrderItemByOid(oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapList;
    }

}
