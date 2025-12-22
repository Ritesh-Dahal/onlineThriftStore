package com.example.online.thrift.store.service;

import com.example.online.thrift.store.dto.request.UsersRegistrationRequest;
import com.example.online.thrift.store.dto.response.UserResponse;
import com.example.online.thrift.store.entity.Users;
import com.example.online.thrift.store.exception.AlreadyExistException;
import com.example.online.thrift.store.exception.NotFoundException;
import com.example.online.thrift.store.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public void userCreation (UsersRegistrationRequest userRequest){

        userRepository.findByEmail(userRequest.getEmail())
                .ifPresent(user -> {throw new AlreadyExistException("User with the email " + userRequest.getEmail()+ " already exist");});

    Users users = new Users(userRequest);
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        userRepository.save(users);
    }


    public void deleteUser(Long id ){

        userRepository.findById(id).orElseThrow(()-> new NotFoundException("User with id "+id +" not found" ));
        userRepository.deleteById(id);
    }


    public UserResponse getUserById(Long id){
        Users users =userRepository.findById(id).orElseThrow(()-> new NotFoundException("User with id "+id +" not found" ));

        UserResponse userResponse= new UserResponse(users);
        return userResponse;
    }


    public List<UserResponse>  getAllUsers(){

        List<Users> usersList = userRepository.findAll();
        List<UserResponse> userResponsesList = usersList.stream().map(UserResponse::new).toList();

        return userResponsesList;
    }

}
