package com.yxw.aop_jdbc;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yan on 2018/7/30.
 */
public interface IUserDao {
    public void save(User user);
    public void update(User user);
    public void delete(Serializable id);
    public User findById(Serializable id);
    public List<User> getAll();
}
