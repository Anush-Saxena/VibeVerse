package com.example.demo.service;

import com.example.demo.entity.SignUpDetails;
import com.example.demo.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    @Autowired
    private LoginRepo loginRepo;
    public String addUser(SignUpDetails signUpDetails){
        if (!loginRepo.existsById(signUpDetails.getPhoneNumber())){
            loginRepo.save(signUpDetails);
            return "Created Successfully";
        }
        else
            return "User already Exists! ";
    }
}
