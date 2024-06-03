package com.sonu.userMicroService.service;

import com.sonu.userMicroService.entity.User;
import com.sonu.userMicroService.payloads.PageableResponse;
import com.sonu.userMicroService.payloads.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    // user operation

    //save user
    UserDto saveUser(UserDto userDto);
    // update user
    UserDto updateUser(UserDto userDto, String userId);
    //get user by id
   UserDto getUserById(String userId);
    //delete user by id
    void deleteUserById(String userId);
    //get all user
  List<UserDto> getAllUser();
}
