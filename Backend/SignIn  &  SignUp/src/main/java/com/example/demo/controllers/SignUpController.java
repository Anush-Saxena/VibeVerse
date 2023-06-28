package com.example.demo.controllers;

import com.example.demo.entity.SignUpDetails;
import com.example.demo.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String addUser(@RequestBody SignUpDetails signUpDetails) {
        return signUpService.addUser(signUpDetails);
    }
}
