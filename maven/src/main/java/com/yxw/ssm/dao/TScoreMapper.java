package com.yxw.ssm.dao;

import com.yxw.ssm.entity.TScore;

public interface TScoreMapper {
    int deleteByPrimaryKey(String scoId);

    int insert(TScore record);

    int insertSelective(TScore record);

    TScore selectByPrimaryKey(String scoId);

    int updateByPrimaryKeySelective(TScore record);

    int updateByPrimaryKey(TScore record);
}