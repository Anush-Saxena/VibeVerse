package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SignedInDetails {
    @Id
    String clientip = "";
    String userName = "";
    String phoneNumber = "";
    String password = "";
    public SignedInDetails() {
        super();
    }

    public SignedInDetails(String userName, String phoneNumber, String password, String clientIp) {
        super();
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.clientip = clientIp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientip() {
        return clientip;
    }

    public void setClientip(String clientip) {
        this.clientip = clientip;
    }
}
