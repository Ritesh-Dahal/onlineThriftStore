package com.example.online.thrift.store.entity;

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
    private Role role;
}
