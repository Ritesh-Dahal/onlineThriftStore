package com.example.online.thrift.store.repository;

import com.example.online.thrift.store.entity.VerifyOtp;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OtpRepo extends JpaRepository<VerifyOtp,Long> {

    Optional<VerifyOtp> findByEmailAndOtp(String email,String otp);

    @Modifying
    @Transactional
    @Query("DELETE FROM VerifyOtp v WHERE v.email = :email")
    void deleteByEmail(String email);
}
