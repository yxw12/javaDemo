package com.bdqn.mapper;

import com.bdqn.pojo.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {

    int login(Student student);
}
