package com.pembekalan.xsisacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pembekalan.xsisacademy.dto.request.UserRequestDto;
import com.pembekalan.xsisacademy.dto.response.ApiResponse;
import com.pembekalan.xsisacademy.dto.response.UserResponseDto;
import com.pembekalan.xsisacademy.entity.User;
import com.pembekalan.xsisacademy.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getAllUsers(){
        List<UserResponseDto> data = userService.getAllUsers();
        return new ResponseEntity<>(new ApiResponse<>(200, "success", data), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){
        UserResponseDto data = userService.getUserById(id);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", data), HttpStatus.OK);
    } 

    @PostMapping("/")
    public ResponseEntity<?> saveUser(@RequestBody UserRequestDto requestDto){
        User data = userService.saveUser(requestDto);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", data), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserRequestDto requestDto){
        requestDto.setId(id);
        User data = userService.saveUser(requestDto);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", data), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        userService.deleteUserById(id);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", null), HttpStatus.OK);

    }

}
