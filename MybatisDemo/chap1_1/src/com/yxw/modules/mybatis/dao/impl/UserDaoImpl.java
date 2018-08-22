package com.yxw.modules.mybatis.dao.impl;

import com.yxw.modules.mybatis.dao.UserDao;
import com.yxw.modules.mybatis.pojo.Order;
import com.yxw.modules.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by Yan on 2018/7/31.
 */
public class UserDaoImpl implements UserDao{
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 根据用户id查找用户
     */
    @Override
    public User findById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("selectId",id);
        return user;
    }

    /**
     * 根据用户名称模糊查询用户
     * @return
     */
    @Override
    public List<User> finadByName(String username) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("selectName", username);
        return userList;
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> findUserList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("selectAll" );
        return userList;
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int number = sqlSession.update("updateUser", user);
        // 需要进行事务提交
        sqlSession.commit();
        return number;
    }

    /**
     * 根据用户id删除用户
     * @param id
     * @return
     */
    @Override
    public int deleteUser(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int deleteNum= sqlSession.delete("deleteUser", id);
        // 需要进行事务提交
        sqlSession.commit();
        return deleteNum;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public int insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int insertNum = sqlSession.insert("insertUser", user);
        // 需要进行事务提交
        sqlSession.commit();
        return insertNum;
    }

    @Override
    public List<Order> findOrderList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Order> orderList = sqlSession.selectList("selectAllOrders" );
        return orderList;
    }

    @Override
    public int insertOrder(Order order) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int insertNum = sqlSession.insert("insertOrder", order);
        // 需要进行事务提交
        sqlSession.commit();
        return insertNum;
    }
}
