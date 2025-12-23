package com.example.online.thrift.store.controller;

import com.example.online.thrift.store.dto.request.LoginDto;
import com.example.online.thrift.store.dto.request.UsersRegistrationRequest;
import com.example.online.thrift.store.dto.response.UserResponse;
import com.example.online.thrift.store.entity.Users;
import com.example.online.thrift.store.service.UserService;
import com.example.online.thrift.store.util.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/auth/register")

    public ResponseEntity<?> registerUser(@RequestBody UsersRegistrationRequest registrationRequest) {

        userService.userCreation(registrationRequest);

        return BaseController.successResponse("User Created Successfully", "{ }");

    }

    @PostMapping("/auth/login")

    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto users) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getEmail(), users.getPassword()));
        String token = jwtUtil.generateToken(users.getEmail());
        Map<String,Object> tokenMap = new HashMap<>();
        tokenMap.put("token",token);

        return BaseController.successResponse("Login success", tokenMap);

    }


    @GetMapping("/user/{id}")

    public ResponseEntity<?> getUserById(@PathVariable Long id) {

        UserResponse userResponse = userService.getUserById(id);
        return BaseController.successResponse("User found with the id: " + id, userResponse);

    }

    @GetMapping("/admin/users")
    public ResponseEntity<?> getAllUsers() {
        List<UserResponse> userList = userService.getAllUsers();

        return BaseController.successResponse("All Users Details:", userList);
    }

    @DeleteMapping("/admin/user/{id}")

    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {

        userService.deleteUser(id);

        return BaseController.successResponse("User Deleted Successfully", "{ }");

    }


}
