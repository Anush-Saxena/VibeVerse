package com.example.demo.service;

import com.example.demo.entity.SignUpDetails;
import com.example.demo.entity.SignedInDetails;
import com.example.demo.repo.Check;
import com.example.demo.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    LoginRepo loginRepo;
    @Autowired
    Check check;

    public SignUpDetails getProfile(String requestIp){
        Optional<SignedInDetails> signedIn = check.findById(requestIp);
        if (signedIn.isPresent()){
            SignUpDetails details = loginRepo.findById(signedIn.get().getPhoneNumber()).get();
            return details;
        }
        return null;
    }
}
