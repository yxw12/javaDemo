package com.yxw.ssm.dao;

import com.yxw.ssm.entity.TStu;

import java.util.List;

public interface TStuMapper {
    int deleteByPrimaryKey(String sNo);

    int insert(TStu record);

    int insertSelective(TStu record);

    TStu selectByPrimaryKey(String sNo);

    int updateByPrimaryKeySelective(TStu record);

    int updateByPrimaryKey(TStu record);

    List<TStu> getAll();

    List<TStu> getAll2();
}