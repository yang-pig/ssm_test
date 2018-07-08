package com.ssmtest.entity;

public class Member {
    private long id;
    private String username;
    private String password;

    private String kouling;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getKouling() {
        return kouling;
    }

    public void setKouling(String kouling) {
        this.kouling = kouling;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", kouling='" + kouling + '\'' +
                '}';
    }
}