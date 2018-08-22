package com.yxw.pojo;

/**
 * Created by Yan on 2018/8/8.
 */
public class Student {
    private int sid;
    private int sno;
    private String sname;
    private String ssex;
    private String stell;
    private ClassInfo classInfo;

    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getStell() {
        return stell;
    }

    public void setStell(String stell) {
        this.stell = stell;
    }
}
