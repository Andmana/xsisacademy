package com.pembekalan.xsisacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pembekalan.xsisacademy.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
    
}
