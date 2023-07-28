package com.example.demo.service;

import com.example.demo.dto.UpdateDetails;
import com.example.demo.entity.SignUpDetails;
import com.example.demo.entity.SignedInDetails;
import com.example.demo.repo.Check;
import com.example.demo.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.demo.methods.StringHashcode.convertToStringHash;

@Service
public class SettingsService {

    @Autowired
    private LoginRepo loginRepo;
    @Autowired
    private Check check;

    public boolean active(String requestIp){
        Optional<SignedInDetails> signedInDetails = check.findById(requestIp);
        if (signedInDetails.isPresent()){
            return true;
        }
        return false;
    }

    public String updateInfo(UpdateDetails updateDetails, String requestIp){

        // Here we check if someone has signedIn or not.
        Optional<SignedInDetails> signedInDetails = check.findById(requestIp);
        if (signedInDetails.isPresent()){
            SignUpDetails info = loginRepo.findById(signedInDetails.get().getPhoneNumber()).get();

            // For uniqueness of PhoneNumber

            if (!info.getPhoneNumber().equals(updateDetails.getPhoneNumber()) && loginRepo.existsById(updateDetails.getPhoneNumber())) {
                return "Not Updated! \nPhone Number already in use";
            }

            // For uniqueness of Username
            Optional<SignUpDetails> checkUserName = loginRepo.findByUserName(updateDetails.getUserName());
            if (!updateDetails.getUserName().equals(updateDetails.getUserName()) && checkUserName.isPresent()) {
                return "Not Updated! \nUser Name already in use";
            }

            // Both Password will be checked in the hashed format

            else if (info.getPassword().equals(convertToStringHash(updateDetails.getOldPassword()))) {
                info.setPassword(convertToStringHash(updateDetails.getPassword()));
                info.setDateOfBirth(updateDetails.getDateOfBirth());
                info.setName(updateDetails.getName());
                info.setUserName(updateDetails.getUserName());
                SignedInDetails updateCheckDetails = signedInDetails.get();
                if (!info.getPhoneNumber().equals(updateDetails.getPhoneNumber())){
                    loginRepo.deleteById(info.getPhoneNumber());
                    info.setPhoneNumber(updateDetails.getPhoneNumber());
                    updateCheckDetails.setPhoneNumber(updateDetails.getPhoneNumber());
                }
                loginRepo.save(info);
                // Password is saved in the hashed form in both the places i.e. @SignedInDetails and @SignUpDetails

                updateCheckDetails.setPassword(convertToStringHash(updateDetails.getPassword()));
                updateCheckDetails.setUserName(updateDetails.getUserName());
                check.save(updateCheckDetails);
                return "Data Updated";
            } else
                return "Incorrect Password";
        }
        else
            return "You need to be Signed In! ";
    }
    public String changePassword(String oldPassword, String newPassword, String requestIp){
        Optional<SignedInDetails> signedIn = check.findById(requestIp);
        if (signedIn.isPresent()){
            SignUpDetails info = loginRepo.findById(signedIn.get().getPhoneNumber()).get();
            String hashOldPassword = convertToStringHash(oldPassword);
            String hashNewPassword = convertToStringHash(newPassword);
            if (info.getPassword().equals(hashOldPassword)){
                info.setPassword(hashNewPassword);
                loginRepo.save(info);
                signedIn.get().setPassword(hashNewPassword);
                check.save(signedIn.get());
                return "Password Changed Successfully";
            } else {
                return "Incorrect Password";
            }
        }
        else return "You need to Sign In first";
    }
    public String deleteUser(String password, String requestIp){
        Optional<SignedInDetails> signedIn = check.findById(requestIp);
        if (signedIn.isPresent()){
            SignUpDetails info = loginRepo.findById(signedIn.get().getPhoneNumber()).get();
            String hashPassword = convertToStringHash(password);
            if (info.getPassword().equals(hashPassword)){
                loginRepo.deleteById(info.getPhoneNumber());
                check.deleteById(requestIp);
                return "User Data Deleted Successfully";
            } else {
                return "Password Incorrect";
            }
        }
        else return "You need to sign In First! ";
    }

    public String signOutUser(String requestIp){
        Optional<SignedInDetails> signedIn = check.findById(requestIp);
        if (signedIn.isPresent()){
            check.deleteById(requestIp);
            return "Signed Out";
        }
        else return "No account signedIn";
    }
}