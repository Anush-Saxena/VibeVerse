package com.example.demo.service;

import com.example.demo.entity.SignUpDetails;
import com.example.demo.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.demo.methods.StringHashcode.convertToStringHash;

@Service
public class SignUpService {

    @Autowired
    private LoginRepo loginRepo;
    public String addUser(SignUpDetails requestSignUpDetails){
        /*
            Here uniqueness of Phone Number is checked.
            Only 1 account is kept with 1 Phone Number since it is also a Primary key in DataBase.
        */
        Optional<SignUpDetails> signUpDetails = loginRepo.findById(requestSignUpDetails.getPhoneNumber());
        if (signUpDetails.isEmpty()){
            /*
                Here we check the uniqueness of the username.
                So they can Login with their username also.
            */
            signUpDetails = loginRepo.findByUserName(requestSignUpDetails.getUserName());
            if (signUpDetails.isEmpty()) {
                /*
                    Here password is converted into hash form and then saved to MySql Table.
                    We haven't checked if the dto are filled or not since it is the part of frontend.
                */
                requestSignUpDetails.setPassword(convertToStringHash(requestSignUpDetails.getPassword()));
                loginRepo.save(requestSignUpDetails);
                return "Created Successfully";
            }
            else{
                return "User Name pre Occupied!";
            }
        }
        else
            return "Phone Number already Exists! ";
    }
}
