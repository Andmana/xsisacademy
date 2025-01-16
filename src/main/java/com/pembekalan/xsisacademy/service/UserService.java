package com.pembekalan.xsisacademy.service;

import java.util.List;

import com.pembekalan.xsisacademy.dto.request.UserRequestDto;
import com.pembekalan.xsisacademy.dto.response.UserResponseDto;
import com.pembekalan.xsisacademy.entity.User;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserById(Integer id);
    User saveUser(UserRequestDto requestDto);
    void deleteUserById(Integer id);
}
