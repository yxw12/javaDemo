package com.yxw.modal;




/**
 * Created by Yan on 2018/7/27.
 */

public class User {
    private String username;
    private String password;
    private String birthday;
    private String age;

    public User() {
    }

    public User(String username, String password, String birthday, String age) {
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
