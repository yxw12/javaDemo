package com.yxw.shop.dao.Impl;

import com.yxw.shop.dao.AdminDao;
import com.yxw.shop.modal.Category;
import com.yxw.shop.modal.Orders;
import com.yxw.shop.modal.Product;
import com.yxw.shop.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Yan on 2018/7/22.
 */
public class AdminDaoImpl implements AdminDao{
    /**
     * 查询商品总类
     * @return
     * @throws SQLException
     */
    @Override
    public List<Category> findByCategory() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from category";
        return runner.query(sql,new BeanListHandler<Category>(Category.class));
    }

    /**
     * 保存商品
     * @param product
     */
    @Override
    public void saveProduct(Product product) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
        Integer integer=runner.update(sql,product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),product.getPdate()
        ,product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCategory().getCid());
        System.out.println(integer);
    }

    /**
     * 查询所有商品
     * @return
     */
    @Override
    public List<Product> findAllProduct() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product order by pid asc";
        return runner.query(sql,new BeanListHandler<Product>(Product.class));
    }

    /**
     * 根据pid删除商品
     * @param pid
     */
    @Override
    public void deleteByPid(String pid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from product where pid=?";
        runner.update(sql,pid);
    }

    /**
     * 根据pid查询商品
     * @param pid
     * @return
     */
    @Override
    public Product selectByPid(String pid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where pid=?";
        Product product= runner.query(sql,new BeanHandler<Product>(Product.class),pid);
        return product;
    }

    /**
     * 根据pid更改商品
     * @param product
     */
    @Override
    public void updateProduct(Product product) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update product set pid=?,pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=?";
        Integer number=runner.update(sql,product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),
                product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCategory().getCid(),product.getPid());
        System.out.println(number);
    }

    /**
     * 添加商品类别
     */
    @Override
    public void addCategory(Category category) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "INSERT INTO category VALUES (?,?)";
        runner.update(sql,category.getCid(),category.getCname());
    }

    /**
     * 删除商品类别
     * @param cid
     */
    @Override
    public void deleteByCid(String cid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from category where cid=?";
        Integer nmuber=runner.update(sql,cid);
        System.out.println(nmuber);
    }

    @Override
    public Category selectByCid(String cid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select *  from category where cid=?";
        Category category= runner.query(sql,new BeanHandler<Category>(Category.class),cid);
        return category;
    }

    @Override
    public void editCategory(Category category) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update category set cname=? where cid=?";
        runner.update(sql,category.getCname(),category.getCid());
    }

    @Override
    public List<Orders> findAllOrders() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from orders";
        List<Orders> ordersList = runner.query(sql, new BeanListHandler<Orders>(Orders.class));
        return ordersList;
    }

    @Override
    public List<Map<String, Object>> findOrderInfoByOid(String oid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select p.pimage,p.pname,p.shop_price,o.count,o.subtotal from product p,orderitem o where p.pid=o.pid and o.oid=?";
        List<Map<String, Object>> mapList = runner.query(sql, new MapListHandler(), oid);
        return mapList;
    }
}
