package com.yxw.ssm.dao;

import com.yxw.ssm.entity.TCourses;

public interface TCoursesMapper {
    int deleteByPrimaryKey(String couId);

    int insert(TCourses record);

    int insertSelective(TCourses record);

    TCourses selectByPrimaryKey(String couId);

    int updateByPrimaryKeySelective(TCourses record);

    int updateByPrimaryKey(TCourses record);
}