package com.cn.yxw.service;

import com.cn.yxw.model.PageBean;
import com.cn.yxw.model.Product;
import com.cn.yxw.model.RegisterUser;
import com.cn.yxw.model.User;

import java.util.Date;
import java.util.List;

import static sun.java2d.cmm.ColorTransform.In;

/**
 * Created by Yan on 2018/7/9.
 */
public interface UserService {
    public void saveUser(User user);

    public void updateUser(User user);

    public User getUserById(Integer UserId);

    public List<User> listUser();

    public void deleteUser(Integer userId);

    public RegisterUser getUserByNameAndPass(String username, String password);

    public PageBean<User> findAll(Integer pageNumber,Integer pageSize);

    public Integer registerUser(String username,String password);

    public List<Product> productFindByWord(String word);

    public PageBean<User> FuzzyfindAll(String word, Date startTime, Date endTime, Integer startIndex, Integer pageSize);

    public PageBean<User> FuzzyOnefindAll(String word, Date startTime, Date endTime, Integer startIndex, Integer pageSize);

}
