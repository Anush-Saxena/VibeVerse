package com.example.demo.service;

import com.example.demo.entity.SignUpDetails;
import com.example.demo.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInService {
    @Autowired
    private LoginRepo loginRepo;

    public String verifyUser(int phoneNumber, String password){
        if (loginRepo.existsById(phoneNumber)){
            SignUpDetails info = loginRepo.getReferenceById(phoneNumber);
            if (info.getPassword().equals(password))
                return "Login Successful";
            else
                return "Wrong Password"+password;
        }
        else
            return "User Doesn't exists";
    }

}
