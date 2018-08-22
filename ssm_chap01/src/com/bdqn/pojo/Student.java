package com.bdqn.pojo;

import java.io.Serializable;

public class Student implements Serializable {
    private int sid;
    private String sno;
    private String sname;
    private String spassword;
    private String ssex;
    private int sage;
    private String stell;

    public Student() {
    }

    public Student(int sid, String sno, String sname,String spassword, String ssex, int sage, String stell) {
        this.sid = sid;
        this.sno = sno;
        this.sname = sname;
        this.spassword=spassword;
        this.ssex = ssex;
        this.sage = sage;
        this.stell = stell;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getStell() {
        return stell;
    }

    public void setStell(String stell) {
        this.stell = stell;
    }


}
