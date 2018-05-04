package com.yz.vip.entity;

public class User {
    private String account;
    private String password;


    public String getName() {
        return account;
    }

    public void setName(String name) {
        this.account = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
