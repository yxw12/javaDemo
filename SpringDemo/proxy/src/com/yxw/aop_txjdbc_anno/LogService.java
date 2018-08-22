package com.yxw.aop_txjdbc_anno;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Yan on 2018/7/31.
 */
@Service
public class LogService {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void startLog(){
        jdbcTemplate.update("INSERT into t_log VALUES (?)","正在插入数据.....");
    }

}
