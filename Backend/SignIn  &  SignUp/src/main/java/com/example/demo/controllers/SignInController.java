package com.example.demo.controllers;

import com.example.demo.details.Details;
import com.example.demo.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignInController {
    @Autowired
    private SignInService signInService;

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String verifyUser(@RequestBody Details details){
        int phoneNumber = details.getPhoneNumber();
        String password = details.getPassword();
        return signInService.verifyUser(phoneNumber, password);
    }
}
