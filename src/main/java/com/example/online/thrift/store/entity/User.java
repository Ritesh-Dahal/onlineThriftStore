package com.example.online.thrift.store.entity;

import com.example.online.thrift.store.dto.request.UsersRegistrationRequest;
import com.example.online.thrift.store.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "users")
public class User {

    public User(UsersRegistrationRequest registrationRequest){
        this.name = registrationRequest.getName();
        this.password= registrationRequest.getPassword();
        this.address= registrationRequest.getAddress();
        this.email= registrationRequest.getEmail();
        this.dateOfBirth= registrationRequest.getDateOfBirth();
        this.phone = registrationRequest.getPhone();
        this.role = registrationRequest.getRole();
        this.gender = registrationRequest.getGender();

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private LocalDateTime dateOfBirth;
    private String address;

    @Column(unique = true,length = 10)
    private String phone;

    private String gender;

    private String password;
    private Role role;
}
