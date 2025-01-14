package com.pembekalan.xsisacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pembekalan.xsisacademy.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
