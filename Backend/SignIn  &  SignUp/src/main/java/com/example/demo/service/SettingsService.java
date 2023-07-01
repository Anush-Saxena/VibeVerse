package com.example.demo.service;

import com.example.demo.details.UpdateDetails;
import com.example.demo.entity.SignUpDetails;
import com.example.demo.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.example.demo.methods.StringHashcode.convertToStringHash;

@Service
public class SettingsService {

    @Autowired
    private LoginRepo loginRepo;

    public String updateInfo(int phoneNumber, UpdateDetails updateDetails){
        if (loginRepo.existsById(phoneNumber)){
            // since the reference will be containing the hashed form
            if (phoneNumber != updateDetails.getPhoneNumber() && loginRepo.existsById(updateDetails.getPhoneNumber())){
                return "Phone Number already in use";
            }
            else if (loginRepo.getReferenceById(phoneNumber).getPassword().equals(convertToStringHash(updateDetails.getOldPassword()))){
                loginRepo.deleteById(phoneNumber);
                // Here the hashed password is entered in the constructor
                loginRepo.save(new SignUpDetails(updateDetails.getPhoneNumber(),updateDetails.getUserName(),convertToStringHash(updateDetails.getPassword())));
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
            String hashOldPassword = convertToStringHash(oldPassword);
            String hashNewPassword = convertToStringHash(newPassword);
            if (info.getPassword().equals(hashOldPassword)) {
                info.setPassword(hashNewPassword);
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
            String hashPassword = convertToStringHash(password);
            if (info.getPassword().equals(hashPassword)) {
                loginRepo.deleteById(phoneNumber);
                return "User Data Deleted Successfully";
            } else {
                return "Password Incorrect"+password;
            }
        }
        else return "Number doesn't exists";
    }
}