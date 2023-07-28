package com.example.demo.controllers;

import com.example.demo.dto.Details;
import com.example.demo.service.SignInService;
import jakarta.servlet.http.HttpServletRequest;
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
    public String verifyUser(HttpServletRequest request, @RequestBody Details details){
        String clientIp = request.getRemoteAddr();
        if (!details.getPhoneNumber().equals("")){
            String phoneNumber = details.getPhoneNumber();
            String password = details.getPassword();
            return signInService.verifyUser(phoneNumber, password, clientIp);
        }
        else{
            String userName = details.getUserName();
            String password = details.getPassword();
            return signInService.verifyUser(userName, password, clientIp);
        }
    }
}
