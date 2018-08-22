package com.bdqn.service.impl;

import com.bdqn.mapper.StudentMapper;
import com.bdqn.pojo.Student;
import com.bdqn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    public boolean login(String username, String password) {
        Student student=new Student();
        student.setSname(username);
        student.setSpassword(password);
        int result = studentMapper.login(student);
        System.out.println(result);
        if(result!=0){
            return true;
        }
        return false;
    }
}
