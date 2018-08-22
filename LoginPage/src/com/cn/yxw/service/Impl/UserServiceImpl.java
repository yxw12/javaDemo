package com.cn.yxw.service.Impl;

import com.cn.yxw.dao.Impl.UserDaoImpl;
import com.cn.yxw.dao.UserDao;
import com.cn.yxw.model.PageBean;
import com.cn.yxw.model.Product;
import com.cn.yxw.model.RegisterUser;
import com.cn.yxw.model.User;
import com.cn.yxw.service.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by Yan on 2018/7/9.
 */
public class UserServiceImpl implements UserService {

    private UserDao UserDao=new UserDaoImpl();
    @Override
    public void saveUser(User user) {
        UserDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        UserDao.updateUser(user);
    }

    @Override
    public User getUserById(Integer UserId) {
        return UserDao.getUserById(UserId);
    }

    @Override
    public List<User> listUser() {
        return UserDao.listUser();
    }

    @Override
    public void deleteUser(Integer userId) {
       UserDao.deleteUser(userId);
    }

    @Override
    public RegisterUser getUserByNameAndPass(String username, String password) {
        return UserDao.getUserByNameAndPass(username,password);
    }

    /**
     * 查询所有分页
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<User> findAll(Integer pageNumber, Integer pageSize) {
        //1.查询总记录数
        Integer totalRecord = UserDao.getTotalRecord();
        //2.总分页数，开始索引，已经在PageBean中处理了
        PageBean<User> pageBean=new PageBean<User>(pageNumber,pageSize,totalRecord);
        //3.查询分页数据
        List<User> data= UserDao.findAll(pageBean.getStartIndex(),pageBean.getPageSize());
        //4.将分页数据封装到PageBean里面
        pageBean.setData(data);
        //5.返回封装好的数据
        return pageBean;
    }

    /**
     * 注册用户
     * @param username
     * @param password
     */
    @Override
    public Integer registerUser(String username,String password){
        return UserDao.registerUser(username,password);
    }

    /**
     * 根据Word查询产品数据
     * @param word
     * @return
     */
    @Override
    public List<Product> productFindByWord(String word){
        return UserDao.productFindByWord(word);
    }

    /**
     * 分页模糊查询所有
     * @param pageNumber
     * @param pageSize
     * @param word
     * @return
     */
    @Override
    public PageBean<User> FuzzyfindAll(String word, Date startTime, Date endTime, Integer pageNumber, Integer pageSize){
        //1.查询总记录数
        Integer totalRecord = UserDao.getTotalRecord();
        //2.总分页数，开始索引，已经在PageBean中处理了
        PageBean<User> pageBean=new PageBean<User>(pageNumber,pageSize,totalRecord);
        //3.查询分页数据
        List<User> data= UserDao.FuzzyfindAll(word,startTime,endTime,pageBean.getStartIndex(),pageBean.getPageSize());
        //4.将分页数据封装到PageBean里面
        pageBean.setData(data);
        //5.返回封装好的数据
        return pageBean;
    }

    /**
     * 分页模糊条件查询
     * @param pageNumber
     * @param pageSize
     * @param word
     * @return
     */
    @Override
    public PageBean<User> FuzzyOnefindAll(String word, Date startTime, Date endTime, Integer pageNumber, Integer pageSize){
        //1.查询总记录数
        Integer totalRecord = UserDao.QueryTotalRecord(word,startTime,endTime);
        //2.总分页数，开始索引，已经在PageBean中处理了
        PageBean<User> pageBean=new PageBean<User>(pageNumber,pageSize,totalRecord);
        //3.查询分页数据
        List<User> data= UserDao.FuzzyfindAll(word,startTime,endTime,pageBean.getStartIndex(),pageBean.getPageSize());
        //4.将分页数据封装到PageBean里面
        pageBean.setData(data);
        //5.返回封装好的数据
        return pageBean;
    }


}
