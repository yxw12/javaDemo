package com.yxw.pojo;

import java.util.List;

/**
 * Created by Yan on 2018/8/8.
 */
public class ClassInfo {
    private int cid;
    private String cname;
    private List<Student>  studentList;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
