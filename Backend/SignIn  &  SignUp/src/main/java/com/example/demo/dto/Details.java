package com.example.demo.dto;




// Sign In Info/Details
public class Details{
    private String phoneNumber = "";
    private String userName="";
    private String password="";

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
}