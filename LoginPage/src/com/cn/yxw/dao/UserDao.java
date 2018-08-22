package com.cn.yxw.dao;

import com.cn.yxw.model.PageBean;
import com.cn.yxw.model.Product;
import com.cn.yxw.model.RegisterUser;
import com.cn.yxw.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Yan on 2018/7/9.
 */
public interface UserDao {
    public void saveUser(User user);

    public void updateUser(User user);

    public User getUserById(Integer userId);

    public List<User> listUser();

    public void deleteUser(Integer userId);

    public RegisterUser getUserByNameAndPass(String username, String password);

    public Integer getTotalRecord();

    public List<User> findAll(Integer startIndex, Integer pageSize);

    public Integer registerUser(String username, String password);

    public List<Product> productFindByWord(String word);

    public List<User> FuzzyfindAll(String word, Date startTime, Date endTime, Integer startIndex, Integer pageSize);

    public Integer QueryTotalRecord(String word, Date startTime, Date endTime);

}
