package com.example.online.thrift.store.service;

import com.example.online.thrift.store.dto.request.UsersRegistrationRequest;
import com.example.online.thrift.store.dto.response.UserResponse;
import com.example.online.thrift.store.entity.User;
import com.example.online.thrift.store.exception.AlreadyExistException;
import com.example.online.thrift.store.exception.NotFoundException;
import com.example.online.thrift.store.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;


    public void userCreation (UsersRegistrationRequest userRequest){

        userRepository.findByEmail(userRequest.getEmail())
                .ifPresent(User -> new AlreadyExistException("User with the email "+userRequest.getEmail()+ " already exist"));

    User user = new User(userRequest);

        userRepository.save(user);
    }


    public void deleteUser(Long id ){

        userRepository.findById(id).orElseThrow(()-> new NotFoundException("User with id "+id +" not found" ));
        userRepository.deleteById(id);
    }


    public UserResponse getUserById(Long id){
        User user =userRepository.findById(id).orElseThrow(()-> new NotFoundException("User with id "+id +" not found" ));

        UserResponse userResponse= new UserResponse(user);
        return userResponse;
    }


    public List<UserResponse>  getAllUsers(){

        List<User> userList = userRepository.findAll();
        List<UserResponse> userResponsesList = userList.stream().map(UserResponse::new).toList();

        return userResponsesList;
    }

}
