package com.yxw.ssm.entity;

public class TScore {
    private String scoId;

    private String stuId;

    private String couId;

    private String scoNum;

    private TCourses courses;

    public TCourses getCourses() {
        return courses;
    }

    public void setCourses(TCourses courses) {
        this.courses = courses;
    }

    public String getScoId() {
        return scoId;
    }

    public void setScoId(String scoId) {
        this.scoId = scoId == null ? null : scoId.trim();
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getCouId() {
        return couId;
    }

    public void setCouId(String couId) {
        this.couId = couId == null ? null : couId.trim();
    }

    public String getScoNum() {
        return scoNum;
    }

    public void setScoNum(String scoNum) {
        this.scoNum = scoNum == null ? null : scoNum.trim();
    }
}