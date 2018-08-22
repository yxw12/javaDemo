package com.yxw.dao;

import com.yxw.pojo.ClassInfo;

import java.util.List;

/**
 * Created by Yan on 2018/8/8.
 */
public interface ClassInfoDao {
    List<ClassInfo> findClasses();
}
