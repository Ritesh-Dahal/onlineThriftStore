package com.example.online.thrift.store.dto.response;

import com.example.online.thrift.store.entity.User;
import com.example.online.thrift.store.enums.Role;
import lombok.*;


import java.time.LocalDateTime;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UserResponse {

    public UserResponse(User user){
        this.id= user.getId();
        this.name= user.getName();
        this.email = user.getEmail();
        this.dateOfBirth = user.getDateOfBirth();
        this.address= user.getAddress();
        this.phone = user.getPhone();
        this.gender = user.getGender();
        this.role = user.getRole();


    }


    private Long id;
    private String name;
    private String email;
    private LocalDateTime dateOfBirth;
    private String address;
    private String phone;
    private String gender;
    private Role role;
}
