package com.example.online.thrift.store.service;

import com.example.online.thrift.store.entity.VerifyOtp;
import com.example.online.thrift.store.repository.OtpRepo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.security.SecureRandom;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine springTemplateEngine;
    private final OtpRepo otpRepo;

    @Value("${spring.mail.username}")
    private String senderEmail;

    @Async
    public void sendOtpEmail(String email) throws MessagingException {


        SecureRandom random = new SecureRandom();
        String otp = String.valueOf(100000 + random.nextInt(900000));


        VerifyOtp verifyOtp = new VerifyOtp();
        verifyOtp.setEmail(email);
        verifyOtp.setOtp(otp);
        otpRepo.save(verifyOtp);


        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(senderEmail);
        helper.setTo(email);
        helper.setSentDate(new Date());
        helper.setSubject("Reset Your Password - OTP");


        Context context = new Context();
        context.setVariable("otp", otp);
        String htmlTemplate = springTemplateEngine.process("reset_link_email", context);

        helper.setText(htmlTemplate, true);


        javaMailSender.send(message);
        log.info("OTP email sent successfully to user {}", email);
    }
}
