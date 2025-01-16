package com.pembekalan.xsisacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pembekalan.xsisacademy.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
    @Query(value = "select c from User c where c.isDeleted = false order by c.name asc")
    List<User> getAllUsers();
}
