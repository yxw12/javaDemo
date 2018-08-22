package com.yxw.ssm.entity;

import java.util.List;

public class TStu {
    private String sNo;

    private String sName;

    private String sClassId;

    private List<TScore> scores;

    public List<TScore> getScores() {
        return scores;
    }

    public void setScores(List<TScore> scores) {
        this.scores = scores;
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo == null ? null : sNo.trim();
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public String getsClassId() {
        return sClassId;
    }

    public void setsClassId(String sClassId) {
        this.sClassId = sClassId == null ? null : sClassId.trim();
    }

    @Override
    public String toString() {
        return "TStu{" +
                "sNo='" + sNo + '\'' +
                ", sName='" + sName + '\'' +
                ", sClassId='" + sClassId + '\'' +
                ", scores=" + scores +
                '}';
    }
}