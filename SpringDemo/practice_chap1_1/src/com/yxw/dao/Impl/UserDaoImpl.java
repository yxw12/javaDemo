package com.yxw.dao.Impl;

import com.yxw.dao.UserDao;
import com.yxw.modal.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yan on 2018/7/27.
 */
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao{

   /* private List<User> userList;

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }*/

    @Override
    public List<User> findUserList() {
        List<User> stuList=new ArrayList<User>();
        User stu1=new User("张三","男","21","13809876541");
        User stu2=new User("李四","男","23","13809876542");
        User stu3=new User("王五","女","25","13809876543");
        User stu4=new User("马六","男","21","13809876544");
        User stu5=new User("田七","女","27","13809876545");
        stuList.add(stu1);
        stuList.add(stu2);
        stuList.add(stu3);
        stuList.add(stu4);
        stuList.add(stu5);
    //    System.out.println(stuList.toString());
        return stuList;
    }
}
