package com.yxw.ssm.service;

import com.yxw.ssm.entity.TStu;

import java.util.List;

/**
 * Created by Yan on 2018/8/13.
 */
public interface StuService {

    TStu selectByPrimaryKey(String sNo);

    List<TStu> getAll();

    List<TStu> getAll2();
}
