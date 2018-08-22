package com.yxw.modal;

/**
 * Created by Yan on 2018/7/26.
 */
public class User {
    private String usrename;
    private String password;
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User() {
        System.out.println("空参构造");
    }

    public String getUsrename() {
        return usrename;
    }

    public void setUsrename(String usrename) {
        this.usrename = usrename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void init(){
        System.out.println("我是初始化方法");
    }
    public void destory(){
        System.out.println("我是销毁方法");
    }

    @Override
    public String toString() {
        return "User{" +
                "usrename='" + usrename + '\'' +
                ", password='" + password + '\'' +
                ", car=" + car +
                '}';
    }

    public User(Car car,String usrename ) {
        this.usrename = usrename;
        this.car = car;
    }

    public User(String usrename, Car car) {
        this.usrename = usrename;
        this.car = car;
    }

    public User(Integer usrename, Car car) {
        this.usrename = usrename+"";
        this.car = car;
    }
}
