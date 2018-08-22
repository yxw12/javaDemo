package com.ht.ces.dao;

import com.ht.ces.model.User;

import java.util.List;

public interface CSUsrDao {
    public void saveUser(User user);

    public void updateUser(User user);

    public User getUserById(Integer userId);

    public List<User> listUser();

    public void deleteUser(Integer userId);

    public User getUserByNameAndPass(String username,String password);
}
