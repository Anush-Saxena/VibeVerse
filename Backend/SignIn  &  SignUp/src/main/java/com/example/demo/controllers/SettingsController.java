package com.example.demo.controllers;

import com.example.demo.dto.Passwords;
import com.example.demo.dto.UpdateDetails;
import com.example.demo.service.SettingsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SettingsController {
    @Autowired
    private SettingsService settingsService;

    @RequestMapping(method = RequestMethod.PUT, value = "/update-info")
    public String updateInfo(HttpServletRequest request, @RequestBody UpdateDetails updateDetails){
        String requestIp = request.getRemoteAddr();
        return settingsService.updateInfo(updateDetails, requestIp);
    }
    @RequestMapping(value = "/change-password", method = RequestMethod.PUT)
    public String changePassword(HttpServletRequest request, @RequestBody Passwords passwords){
        String requestIp = request.getRemoteAddr();
        String oldPassword = passwords.getOldPassword();
        String newPassword = passwords.getNewPassword();
        return settingsService.changePassword(oldPassword, newPassword, requestIp);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public String deleteUser(HttpServletRequest request, @RequestBody String password){
        String requestIp = request.getRemoteAddr();
        return settingsService.deleteUser(password, requestIp);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/signOut")
    public String signOutUser(HttpServletRequest request){
        String requestIp = request.getRemoteAddr();
        return settingsService.signOutUser(requestIp);
    }
}
