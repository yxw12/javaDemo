package com.yxw.pojo;

import java.util.Date;

/**
 * Created by Yan on 2018/8/1.
 */
public class User {
    private Integer u_id;
    private String  u_name;
    private Integer u_age;
    private String u_sex;
    private String u_tell;
    private Date u_birthday;

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public Integer getU_age() {
        return u_age;
    }

    public void setU_age(Integer u_age) {
        this.u_age = u_age;
    }

    public String getU_sex() {
        return u_sex;
    }

    public void setU_sex(String u_sex) {
        this.u_sex = u_sex;
    }

    public String getU_tell(String string) {
        return u_tell;
    }

    public void setU_tell(String u_tell) {
        this.u_tell = u_tell;
    }

    public Date getU_birthday(java.sql.Date date) {
        return u_birthday;
    }

    public void setU_birthday(Date u_birthday) {
        this.u_birthday = u_birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", u_age=" + u_age +
                ", u_sex='" + u_sex + '\'' +
                ", u_tell='" + u_tell + '\'' +
                ", u_birthday=" + u_birthday +
                '}';
    }
}
