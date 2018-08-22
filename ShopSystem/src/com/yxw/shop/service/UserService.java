package com.yxw.shop.service;

import com.yxw.shop.modal.User;


/**
 * Created by Yan on 2018/7/17.
 */
public interface UserService {
    public int regist(User user);//注册用户

    public void active(String activeCode);//激活用户

    public Long checkUsername(String username);//校验用户名是否存在


    public  User findUserByNamePass(String username, String password);
}
