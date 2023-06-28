package com.example.demo.service;

import com.example.demo.details.UpdateDetails;
import com.example.demo.entity.SignUpDetails;
import com.example.demo.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsService {

    @Autowired
    private LoginRepo loginRepo;

    public String updateInfo(int phoneNumber, UpdateDetails updateDetails){
        if (loginRepo.existsById(phoneNumber)){
            if (loginRepo.getReferenceById(phoneNumber).getPassword().equals(updateDetails.getOldPassword())){
                loginRepo.deleteById(phoneNumber);
                loginRepo.save(new SignUpDetails(updateDetails.getPhoneNumber(),updateDetails.getUserName(),updateDetails.getPassword()));
                return "Data Updated";
            }
            else
                return "Incorrect Password";
        }
        else return "Number doesn't exists";
    }
    public String changePassword(int phoneNumber, String oldPassword, String newPassword){
        if (loginRepo.existsById(phoneNumber)){
            SignUpDetails info = loginRepo.getReferenceById(phoneNumber);
            if (info.getPassword().equals(oldPassword)) {
                info.setPassword(newPassword);
                loginRepo.deleteById(phoneNumber);
                loginRepo.save(info);
                return "Password Changed Successfully";
            } else {
                return "Incorrect Password";
            }
        }
        else return "Number doesn't exists";
    }
    public String deleteUser(int phoneNumber, String password){
        if (loginRepo.existsById(phoneNumber)) {
            SignUpDetails info = loginRepo.getReferenceById(phoneNumber);
            if (info.getPassword().equals(password)) {
                loginRepo.deleteById(phoneNumber);
                return "User Data Deleted Successfully";
            } else {
                return "Password Incorrect"+password;
            }
        }
        else return "Number doesn't exists";
    }
}