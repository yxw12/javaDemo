package com.yxw.shop.dao.Impl;

import com.yxw.shop.dao.ProductDao;
import com.yxw.shop.modal.Category;
import com.yxw.shop.modal.OrderItem;
import com.yxw.shop.modal.Orders;
import com.yxw.shop.modal.Product;
import com.yxw.shop.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Yan on 2018/7/18.
 */
public class ProductDaoImpl implements ProductDao {
    /**
     * 查找最新商品
     * @return
     */
    @Override
    public List<Product> findByHotProduct() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where is_hot=? limit ?,?";
        return runner.query(sql,new BeanListHandler<Product>(Product.class),1,0,9);
    }

    /**
     * 查找最新商品
     * @return
     */
    @Override
    public List<Product> findByNewProduct() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product order by pdate desc limit ?,?";
        return runner.query(sql,new BeanListHandler<Product>(Product.class),0,9);
    }

    /**
     * 查找商品类别
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
     * 根据cid查商品总数
     * @param cid
     * @return
     * @throws SQLException
     */
    @Override
    public Integer getTotal(String cid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from product where cid=?";
        Long total = (Long) runner.query(sql,new ScalarHandler(),cid);
        Integer totalNumber=total.intValue();
        return totalNumber;
    }

    /**
     * 查每一页分页数量
     * @param cid
     * @param index
     * @param pageSize
     * @return
     */
    @Override
    public List<Product> findProductByPage(String cid, Integer index, Integer pageSize) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where cid=? limit ?,?";
        List<Product> list = runner.query(sql,new BeanListHandler<Product>(Product.class),cid,index,pageSize);
        return list;
    }

    /**
     * 通过商品pid查询商品
     * @param pid
     * @return
     */
    @Override
    public  Product findProductByPid(String pid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where pid=?";
        Product product=runner.query(sql,new BeanHandler<Product>(Product.class),pid);
        return product;
    }

    /**
     * 根据pid删除商品
     * @param pid
     * @throws SQLException
     */
    @Override
    public Integer deleteByPid(String pid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from product where pid=?";
        return runner.update(sql,pid);
    }

    /**
     * 添加订单到数据库
     * @param orders
     */
    @Override
    public void insertOrders(Orders orders) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "INSERT INTO orders VALUES (?,?,?,?,?,?,?,?)";
        Connection conn = DataSourceUtils.getConnection();
        runner.update(conn,sql,orders.getOid(),orders.getOrdertime(),orders.getTotal(),orders.getState(),orders.getAddress(),
                orders.getName(),orders.getTelephone(),orders.getUser().getUid());
    }

    /**
     * 添加订单项
     * @param orders
     */
    @Override
    public void insertOrderitem(Orders orders) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "INSERT INTO orderitem VALUES (?,?,?,?,?)";
        Connection conn = DataSourceUtils.getConnection();
        List<OrderItem> orderItems = orders.getOrderItems();
        for (OrderItem item:orderItems
             ) {
            runner.update(conn,sql,item.getItemid(),item.getCount(),item.getSubtotal(),item.getProduct().getPid(),item.getOrders().getOid());
        }

    }

    /**
     * 更新订单表
     * @param orders
     * @return
     */
    @Override
    public void updateOrders(Orders orders) throws SQLException {
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="UPDATE orders SET address=?,name=?,telephone=? WHERE oid=?";
        runner.update(sql, orders.getAddress(),orders.getName(),orders.getTelephone(),orders.getOid());
    }

    /**
     * 更改付款商品状态
     * @param r6_order
     */
    @Override
    public void updateOrderState(String r6_order) throws SQLException {
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="UPDATE orders SET state=? WHERE oid=?";
        runner.update(sql,1,r6_order);
    }

    /**
     * 根据订单编号查询订单详情
     * @param uid
     * @return
     */
    @Override
    public List<Orders> findAllOrders(String uid) throws SQLException {
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from orders where uid=? ";
        List<Orders> list = runner.query(sql, new BeanListHandler<Orders>(Orders.class), uid);
        return list;
    }

    /**
     * 根据oid多表查找OrderItem
     * @param oid
     * @return
     */
    @Override
    public List<Map<String, Object>> findAllOrderItemByOid(String oid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select i.count,i.subtotal,p.pimage,p.pname,p.shop_price from orderitem i,product p where i.pid=p.pid and i.oid=?";
        List<Map<String, Object>> mapList = runner.query(sql, new MapListHandler(), oid);
        return mapList;
    }

    /**
     * 根据订单编号查询订单详情
     * @param uid
     * @return
     */
    @Override
    public List<Orders> findPageAllOrders(String uid,Integer index, Integer pageSize) throws SQLException {
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from orders where uid=? limit ?,?";
        List<Orders> list = runner.query(sql, new BeanListHandler<Orders>(Orders.class), uid,index,pageSize);
        return list;
    }

    /**
     * 查询订单总数
     * @param uid
     * @return
     * @throws SQLException
     */
    public Integer getOrderPageTotal(String uid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from orders where uid=?";
        Long total = (Long) runner.query(sql,new ScalarHandler(),uid);
        Integer totalNumber=total.intValue();
        return totalNumber;
    }
}
