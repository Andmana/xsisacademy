package com.pembekalan.xsisacademy.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pembekalan.xsisacademy.dto.request.UserRequestDto;
import com.pembekalan.xsisacademy.dto.response.UserResponseDto;
import com.pembekalan.xsisacademy.entity.User;
import com.pembekalan.xsisacademy.repository.UserRepository;
import com.pembekalan.xsisacademy.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    private ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        // TODO Auto-generated method stub
        List<User> users = userRepository.findAll();
        List<UserResponseDto> userResponseDtos = users.stream().map(user -> modelMapper().map(user, UserResponseDto.class)).collect(Collectors.toList());
        return userResponseDtos;
    }

    @Override
    public UserResponseDto getUserById(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        UserResponseDto userResponseDto = modelMapper().map(user, UserResponseDto.class);
        return userResponseDto;
    }

    @Override
    public User saveUser(UserRequestDto userRequestDto) {
        User user = modelMapper().map(userRequestDto, User.class);
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

     
    
}
