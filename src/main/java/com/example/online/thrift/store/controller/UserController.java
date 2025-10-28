package com.example.online.thrift.store.controller;

import com.example.online.thrift.store.dto.request.UsersRegistrationRequest;
import com.example.online.thrift.store.dto.response.UserResponse;
import com.example.online.thrift.store.entity.Users;
import com.example.online.thrift.store.service.UserService;
import com.example.online.thrift.store.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {

    private UserService userService;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    @PostMapping("/register")

    public ResponseEntity<?> registerUser(@RequestBody UsersRegistrationRequest registrationRequest){

        userService.userCreation(registrationRequest);

        return BaseController.successResponse("User Created Successfully","{ }");

    }

    @PostMapping("/login")

    public ResponseEntity<?> authenticateUSer(@RequestBody Users users){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getEmail(), users.getPassword()));
            return new ResponseEntity<>("TOKEN:\n"+jwtUtil.generateToken(users.getEmail()),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/user/{id}")

    public ResponseEntity<?> getUserById(@PathVariable Long id){

        UserResponse userResponse = userService.getUserById(id);
        return BaseController.successResponse("User found with the id: "+id,userResponse);

    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        List<UserResponse> userList = userService.getAllUsers();

        return BaseController.successResponse("All Users Details:" , userList);
    }

    @DeleteMapping("/user/{id}")

    public ResponseEntity<?> deleteUserById(@PathVariable Long id){

        userService.deleteUser(id);

        return BaseController.successResponse("User Deleted Successfully","{ }");

    }


}
