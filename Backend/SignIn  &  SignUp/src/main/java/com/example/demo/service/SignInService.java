package com.example.demo.service;

import com.example.demo.entity.SignedInDetails;
import com.example.demo.entity.SignUpDetails;
import com.example.demo.repo.Check;
import com.example.demo.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.demo.methods.StringHashcode.convertToStringHash;

@Service
public class SignInService {
    @Autowired
    private LoginRepo loginRepo;
    @Autowired
    private Check check;

    /*
        This part is for the users using phoneNumber to LogIn in their account.
    */
    public String verifyUser(String numberOrName, String password, String clientIp){
        Optional<SignUpDetails> detailsOptional;
        if (numberOrName.matches("\\d+")) {
            detailsOptional = loginRepo.findById(numberOrName);
        }
        else {
            detailsOptional = loginRepo.findByUserName(numberOrName);
        }
        if (detailsOptional.isPresent()) {

            // Here info will contain the password in hashed form.

            SignUpDetails info = detailsOptional.get();
            String hashPassword = convertToStringHash(password);
            if (info.getPassword().equals(hashPassword)){

                /*
                Since Info contains the password in hashed form, so it is stored in the same form in signInDetails.
                */

                check.save(new SignedInDetails(info.getUserName(), info.getPhoneNumber(), info.getPassword(),clientIp));
                return "Login Successful";
            }
            else
                return "Wrong Password";
        }
        else
            return "User Doesn't exists";
    }
}
