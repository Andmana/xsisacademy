package com.pembekalan.xsisacademy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pembekalan.xsisacademy.entity.User;
import com.pembekalan.xsisacademy.repository.UserRepository;
import com.pembekalan.xsisacademy.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
        // TODO Auto-generated method stub
    }

    @Override
    public User saveUser(User user) {
        // TODO Auto-generated method stub
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
    
    
}
