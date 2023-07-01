package com.example.demo.service;

import com.example.demo.entity.SignUpDetails;
import com.example.demo.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.example.demo.methods.StringHashcode.convertToStringHash;

@Service
public class SignInService {
    @Autowired
    private LoginRepo loginRepo;

    public String verifyUser(int phoneNumber, String password){
        if (loginRepo.existsById(phoneNumber)){
                // Here info will contain the password in hashed form.
            SignUpDetails info = loginRepo.getReferenceById(phoneNumber);
            String hashPassword = convertToStringHash(password);
            if (info.getPassword().equals(hashPassword))
                return "Login Successful";
            else
                return "Wrong Password";
        }
        else
            return "User Doesn't exists";
    }

}
