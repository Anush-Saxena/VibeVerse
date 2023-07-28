package com.example.demo.dto;

import com.example.demo.entity.SignUpDetails;

public class UpdateDetails extends SignUpDetails {
    private String oldPassword;
    public void setOldPassword(String oldPassword){
        this.oldPassword = oldPassword;
    }
    public String getOldPassword() {
        return oldPassword;
    }
}
