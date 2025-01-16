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

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<UserResponseDto> getAllUsers() {
        // TODO Auto-generated method stub
        List<User> users = userRepository.getAllUsers();
        List<UserResponseDto> data = users.stream().map(user -> modelMapper.map(user, UserResponseDto.class)).collect(Collectors.toList());
        return data;
    }

    @Override
    public UserResponseDto getUserById(Integer id) {
        // TODO Auto-generated method stub
        User user = userRepository.findById(id).orElse(null);
        UserResponseDto data = modelMapper.map(user, UserResponseDto.class);
        return data;
    }

    @Override
    public User saveUser(UserRequestDto requestDto) {
        // TODO Auto-generated method stub
        User data = modelMapper.map(requestDto, User.class);
        return userRepository.save(data);
    }

    @Override
    public void deleteUserById(Integer id) {
        // TODO Auto-generated method stub
        User data = userRepository.findById(id).orElse(null);
        if (data != null){
            data.setDeleted(true);
            userRepository.save(data);
        }
    }
    
}
