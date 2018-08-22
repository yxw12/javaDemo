package com.ht.ces.service.Impl;

import com.ht.ces.dao.CSUsrDao;
import com.ht.ces.dao.Impl.CSUsrDaoImpl;
import com.ht.ces.model.User;
import com.ht.ces.service.CSUsrService;

import java.util.List;

public class CSUsrServiceImpl implements CSUsrService {

    private CSUsrDao csUsrDao=new CSUsrDaoImpl();
    @Override
    public void saveUser(User user) {
        csUsrDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        csUsrDao.updateUser(user);
    }

    @Override
    public User getUserById(Integer UserId) {
        return csUsrDao.getUserById(UserId);
    }

    @Override
    public List<User> listUser() {
        return csUsrDao.listUser();
    }

    @Override
    public void daleteUser(Integer userId) { csUsrDao.deleteUser(userId); }

    @Override
    public User getUserByNameAndPass(String username, String password) { return csUsrDao.getUserByNameAndPass(username,password); }
}
