package com.yxw.aop_txjdbc_anno;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by Yan on 2018/7/30.
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private LogService logService;

    //当前方法应用事务
    @Transactional(
            readOnly = false,               //读写的事务时候用，当修改数据时候用；如果查询就设置为true
            isolation= Isolation.DEFAULT,    //事务隔离级别
            timeout=-1,                      //事务执行的超时时间，-1 表示不超时
        //    noRollbackFor = ArithmeticException.class,   //遇到指定的异常不回滚
            propagation = Propagation.REQUIRED     //事务传播行为
    )
    public void save(User user){
        logService.startLog();
     //   userDao.save(user);
      //  int i=1/0;
        userDao.save(user);
    }

    @Transactional
    public void delete(Serializable id){
        userDao.delete(id);
    }

    public void update(User user){
        userDao.update(user);
    }
}
