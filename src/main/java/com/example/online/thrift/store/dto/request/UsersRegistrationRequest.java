package com.example.online.thrift.store.dto.request;

import com.example.online.thrift.store.enums.Role;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UsersRegistrationRequest {
private String name;
private String email;
private LocalDateTime dateOfBirth;
private String address;
private String phone;
private String gender;
private Role role;

}
