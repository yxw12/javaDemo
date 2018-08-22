package com.ht.ces.service;

import com.ht.ces.model.User;

import java.util.List;

public interface CSUsrService {
    public void saveUser(User user);

    public void updateUser(User user);

    public User getUserById(Integer UserId);

    public List<User> listUser();

    public void daleteUser(Integer userId);

    public User getUserByNameAndPass(String username,String password);
}
