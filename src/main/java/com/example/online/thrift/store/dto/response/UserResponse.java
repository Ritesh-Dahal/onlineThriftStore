package com.example.online.thrift.store.dto.response;

import com.example.online.thrift.store.entity.Users;
import com.example.online.thrift.store.enums.Role;
import lombok.*;


import java.time.LocalDate;
import java.time.LocalDateTime;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UserResponse {

    public UserResponse(Users users){
        this.id= users.getId();
        this.name= users.getName();
        this.email = users.getEmail();
        this.dateOfBirth = users.getDateOfBirth();
        this.address= users.getAddress();
        this.phone = users.getPhone();
        this.gender = users.getGender();
        this.role = users.getRole();


    }


    private Long id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private String address;
    private String phone;
    private String gender;
    private Role role;
}
