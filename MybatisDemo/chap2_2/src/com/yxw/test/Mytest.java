package com.yxw.test;

import com.yxw.dao.ClassInfoDao;
import com.yxw.dao.StudentDao;
import com.yxw.pojo.ClassInfo;
import com.yxw.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * Created by Yan on 2018/8/8.
 */
public class Mytest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void testBefore() throws IOException {
        // 2. 加载SqlMapConfig.xml配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 1. 创建SqlSessionFactoryBuilder对象
        // 3. 创建SqlSessionFactory对象
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testStudent(){
        SqlSession session = sqlSessionFactory.openSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        List<Student> students = mapper.findStudents();
        for (Student s:students) {
            System.out.println(s.getSname()+"..."+s.getClassInfo().getCname());
        }
        // mybatis和spring整合，整合之后，交给spring管理
        session.close();
    }

    @Test
    public void testClass(){
        SqlSession session = sqlSessionFactory.openSession();
        ClassInfoDao mapper = session.getMapper(ClassInfoDao.class);
        List<ClassInfo> classes = mapper.findClasses();
        for (ClassInfo c:classes) {
            System.out.print(c.getCname()+".....");
            for(Student s:c.getStudentList()){
                System.out.print(s.getSname()+"\t");
            }
            System.out.println();
        }
        // mybatis和spring整合，整合之后，交给spring管理
        session.close();
    }
}
