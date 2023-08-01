package com.example.demo.controllers;

import com.example.demo.entity.SignUpDetails;
import com.example.demo.service.ProfileService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
@RestController
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @RequestMapping(method = RequestMethod.GET, value="/profile")
    public SignUpDetails profile(HttpServletRequest request){
        String requestIp = request.getRemoteAddr();
        return profileService.getProfile(requestIp);
    }
}
