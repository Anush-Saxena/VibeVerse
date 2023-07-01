package com.example.demo.service;

import com.example.demo.entity.SignUpDetails;
import com.example.demo.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.example.demo.methods.StringHashcode.convertToStringHash;

@Service
public class SignUpService {

    @Autowired
    private LoginRepo loginRepo;
    public String addUser(SignUpDetails signUpDetails){
        if (!loginRepo.existsById(signUpDetails.getPhoneNumber())){
// Here password is converted into hash form and then saved to MySql Table.
            signUpDetails.setPassword(convertToStringHash(signUpDetails.getPassword()));
            loginRepo.save(signUpDetails);
            return "Created Successfully";
        }
        else
            return "User already Exists! ";
    }
}
