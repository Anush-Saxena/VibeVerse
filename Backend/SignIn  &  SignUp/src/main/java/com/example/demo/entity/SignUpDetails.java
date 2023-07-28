package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SignUpDetails {
    @Id
    private String phoneNumber= "";  // Phone Number of the user
    private String name="";     // Account Holder's Name
    private String userName="";  // userName of the person's account
    private String password="";
    private String dateOfBirth ="";

    public SignUpDetails() {
    }

    public SignUpDetails(String phoneNumber, String name, String userName, String password, String dateOfBirth) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isNotEmpty(){
        return this.phoneNumber.equals("") && !this.userName.equals("") && !this.password.equals("");
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
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
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
