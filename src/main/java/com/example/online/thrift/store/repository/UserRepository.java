package com.example.online.thrift.store.repository;

import com.example.online.thrift.store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
