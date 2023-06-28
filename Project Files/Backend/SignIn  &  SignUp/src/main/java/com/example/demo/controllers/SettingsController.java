package com.example.demo.controllers;

import com.example.demo.details.Passwords;
import com.example.demo.details.UpdateDetails;
import com.example.demo.entity.SignUpDetails;
import com.example.demo.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SettingsController {
    @Autowired
    private SettingsService settingsService;

    @RequestMapping(method = RequestMethod.PUT, value = "/update-info/{phoneNumber}")
    public String updateInfo(@PathVariable int phoneNumber, @RequestBody UpdateDetails updateDetails){
        return settingsService.updateInfo(phoneNumber, updateDetails);
    }
    @RequestMapping(value = "/change-password/{phoneNumber}", method = RequestMethod.PUT)
    public String changePassword(@PathVariable int phoneNumber, @RequestBody Passwords passwords){
        String oldPassword = passwords.getOldPassword();
        String newPassword = passwords.getNewPassword();
        return settingsService.changePassword(phoneNumber,oldPassword, newPassword);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{phoneNumber}")
    public String deleteUser(@PathVariable int phoneNumber,  @RequestBody String password){
        return settingsService.deleteUser(phoneNumber,password);
    }
}
