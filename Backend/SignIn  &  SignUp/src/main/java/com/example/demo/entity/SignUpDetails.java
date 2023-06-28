package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SignUpDetails {
    @Id
    private int phoneNumber=0;
    private String userName="";
    private String password="";
    public SignUpDetails() {
    }

    public SignUpDetails(int phoneNumber, String userName, String password) {
        super();
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
    }

    public boolean isNotEmpty(){
        return this.phoneNumber != 0 && !this.userName.equals("") && !this.password.equals("");
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
