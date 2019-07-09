package com.gl.common.user.bean;

public class User {
    private int id;
    private String username;
    private String password;
    private String role;
    private String phonenumber;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User() {
    }

    public User(int id, String username, String password, String role, String phonenumber, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.phonenumber = phonenumber;
        this.address = address;
    }
}
