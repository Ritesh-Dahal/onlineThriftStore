package com.example.online.thrift.store.service;

import com.example.online.thrift.store.entity.Users;
import com.example.online.thrift.store.exception.NotFoundException;
import com.example.online.thrift.store.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

        private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByEmail(username).orElseThrow(()-> new NotFoundException("Invalid Email or Password"));
        return new User(users.getEmail(),users.getPassword(), List.of(new SimpleGrantedAuthority(users.getRole().name())));
    }
}
