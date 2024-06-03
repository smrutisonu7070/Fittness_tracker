package com.sonu.userMicroService.service.impl;

import com.sonu.userMicroService.entity.User;
import com.sonu.userMicroService.exception.UserNotFoundException;
import com.sonu.userMicroService.payloads.PageableResponse;
import com.sonu.userMicroService.payloads.UserDto;
import com.sonu.userMicroService.repository.UserRepo;
import com.sonu.userMicroService.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {

        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        //generate unique id
        String id = UUID.randomUUID().toString();
        User user = this.modelMapper.map(userDto, User.class);
        user.setUserId(id);
        user.setPassword(user.getPassword());

        return this.modelMapper.map(this.userRepo.save(user), UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        Optional<User> userOptional = this.userRepo.findById(userId);
        User existingUser = userOptional.orElseThrow(() -> new UserNotFoundException(String.format("User of %s is not found !!", userId)));
        existingUser.setUserName(userDto.getUserName());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setAbout(userDto.getAbout());
        existingUser.setPassword(userDto.getPassword());

        //save data
        User updatedUser = userRepo.save(existingUser);
        UserDto updatedUserDto = this.modelMapper.map(updatedUser, UserDto.class);

        return updatedUserDto;
    }

    @Override
    public UserDto getUserById(String userId) {
        Optional<User> userOptional = this.userRepo.findById(userId);
        User existingUser = userOptional.orElseThrow(() -> new UserNotFoundException(String.format("User of %s is not found !!", userId)));
        return this.modelMapper.map(existingUser, UserDto.class);
    }
    @Override
    public void deleteUserById(String userId) {
         this.userRepo.deleteById(userId);
    }
    @Override
    public List<UserDto> getAllUser() {

        List<User> allExistingUsers = this.userRepo.findAll();

        List<UserDto> userDtoList = allExistingUsers.stream().map(allExistingUser ->
                this.modelMapper.map(allExistingUser, UserDto.class)).collect(Collectors.toList());

        return userDtoList;
    }

}
