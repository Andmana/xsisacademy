package com.pembekalan.xsisacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pembekalan.xsisacademy.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
