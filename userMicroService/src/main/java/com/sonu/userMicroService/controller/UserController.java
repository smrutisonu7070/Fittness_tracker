package com.sonu.userMicroService.controller;

import com.sonu.userMicroService.payloads.PageableResponse;
import com.sonu.userMicroService.payloads.UserDto;
import com.sonu.userMicroService.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //save user
    @PutMapping
    ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto userDto) {

        UserDto userDto1 = this.userService.saveUser(userDto);
        return  ResponseEntity.ok(userDto1);
    }
    // update user
    @PutMapping("/{userId}")
    ResponseEntity<UserDto> updateUser(
            @PathVariable String userId,
            @Valid
            @RequestBody UserDto userDto) {

        UserDto savedUserDto = this.userService.updateUser(userDto, userId);
        return  new ResponseEntity<UserDto>(savedUserDto, HttpStatus.CREATED);
    }
    //get user by id
    @GetMapping("/{userId}")
    ResponseEntity<UserDto> getUserById(@PathVariable String userId) {

        UserDto existingUserDto = this.userService.getUserById(userId);
        return  ResponseEntity.ok(existingUserDto);
    }
    //delete user by id
    @DeleteMapping("/{userId}")
    ResponseEntity<String> deleteUserById(@PathVariable String userId) {

        this.userService.deleteUserById(userId);
        return ResponseEntity.ok(String.format("User with user-id %s deleted successfully", userId));
    }
    //get all user
    @GetMapping
    ResponseEntity<List<UserDto>> getAllUser() {

        List<UserDto> existingUserDtoList = this.userService.getAllUser();
        return  ResponseEntity.ok(existingUserDtoList);
    }
}
