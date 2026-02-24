package com.example.online.thrift.store.service;

import com.example.online.thrift.store.dto.request.ResetPasswordRequest;
import com.example.online.thrift.store.dto.request.VerifyOtpRequest;
import com.example.online.thrift.store.entity.Users;
import com.example.online.thrift.store.entity.VerifyOtp;
import com.example.online.thrift.store.exception.NotFoundException;
import com.example.online.thrift.store.repository.OtpRepo;
import com.example.online.thrift.store.repository.UserRepository;
import com.example.online.thrift.store.util.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ForgetPassword {

    private final UserRepository userRepository;
    private final OtpRepo otpRepo;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;



    public Map<String,Object> verifyOtp(VerifyOtpRequest verifyOtpRequest){

       VerifyOtp otp = otpRepo.findByEmailAndOtp(verifyOtpRequest.getEmail(),verifyOtpRequest.getOtp()).orElseThrow(()-> new NotFoundException("Invalid Credentials"));

       deleteOtp(verifyOtpRequest.getEmail());

        userRepository.findByEmail(verifyOtpRequest.getEmail()).orElseThrow(()->new NotFoundException("Invalid User Email"));

        String token = jwtUtil.generateToken(verifyOtpRequest.getEmail());
        Map<String,Object> tokenMap = new HashMap<>();
        tokenMap.put("token",token);

        return tokenMap;




    }


    public void resetPassword(ResetPasswordRequest resetPassword){

        Users user = userRepository.findByEmail(resetPassword.getEmail()).orElseThrow(()-> new NotFoundException("Invalid User"));
            user.setPassword(passwordEncoder.encode(resetPassword.getPassword()));
            userRepository.save(user);


    }

    @Transactional
    public void deleteOtp(String email){
        otpRepo.deleteByEmail(email);

    }

}
