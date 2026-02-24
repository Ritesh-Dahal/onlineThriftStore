package com.example.online.thrift.store.controller;

import com.example.online.thrift.store.dto.request.CartRequest;
import com.example.online.thrift.store.dto.request.ResetPasswordRequest;
import com.example.online.thrift.store.dto.request.SendOtp;
import com.example.online.thrift.store.dto.request.VerifyOtpRequest;
import com.example.online.thrift.store.entity.VerifyOtp;
import com.example.online.thrift.store.service.EmailService;
import com.example.online.thrift.store.service.ForgetPassword;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ForgetPasswordController {
    private final ForgetPassword forgetPassword;
    private final EmailService emailService;


    @PostMapping("/auth/forget-password")
    public ResponseEntity<?> forgetPassword(@RequestBody SendOtp sendOtp) throws MessagingException {
        emailService.sendOtpEmail(sendOtp.getEmail());
        return BaseController.successResponse("Email Send Successfully", "{}");

    }

    @PostMapping("/auth/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody VerifyOtpRequest verifyOtp) throws MessagingException {
        return BaseController.successResponse("OTP verified Successfully",forgetPassword.verifyOtp(verifyOtp));

    }


    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest){
        forgetPassword.resetPassword(resetPasswordRequest);
        return BaseController.successResponse("Password Reset Successfully", HttpStatus.OK);

    }


}
