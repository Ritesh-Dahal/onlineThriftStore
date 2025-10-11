package com.example.online.thrift.store.dto.response;

import com.example.online.thrift.store.enums.Role;
import lombok.*;


import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter

public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime dateOfBirth;
    private String address;
    private String phone;
    private String gender;
    private Role role;
}
