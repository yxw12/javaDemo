package com.yxw.ssm.service.impl;

import com.yxw.ssm.dao.TStuMapper;
import com.yxw.ssm.entity.TStu;
import com.yxw.ssm.service.StuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yan on 2018/8/13.
 */
@Service
public class StuServiceImpl implements StuService{

    @Resource
    protected TStuMapper tStuMapper;
    @Override
    public TStu selectByPrimaryKey(String sNo) {
        return tStuMapper.selectByPrimaryKey(sNo);
    }

    @Override
    public List<TStu> getAll() {
        return tStuMapper.getAll();
    }

    @Override
    public List<TStu> getAll2() {
        return tStuMapper.getAll2();
    }
}
