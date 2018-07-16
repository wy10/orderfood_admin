package com.rimi.cs.pojo;

public class User {
    private Integer userid;

    private String username;

    private String password;

    private String phoneNum;

    private Integer money;

    private String mess;

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public User(String username){
        this.username = username;
    }
    public User(Integer userid, String username, String password, String phoneNum) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
        this.money = money;
    }

    public User(){

    }

    public User(String username,String mess,String password){
        this.username = username;
        this.mess = mess;
        this.password=password;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}