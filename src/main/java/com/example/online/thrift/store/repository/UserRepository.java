package com.example.online.thrift.store.repository;

import com.example.online.thrift.store.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {
  List<Users> findByIdIn(List<Long> userIds);
  Optional<Users> findByEmail(String email);

}
