package com.yxw.dao;

import com.yxw.pojo.Student;

import java.util.List;

/**
 * Created by Yan on 2018/8/8.
 */
public interface StudentDao {
    List<Student> findStudents();
}
