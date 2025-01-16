package com.pembekalan.xsisacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pembekalan.xsisacademy.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    
}
