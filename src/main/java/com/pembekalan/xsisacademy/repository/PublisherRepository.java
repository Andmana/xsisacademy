package com.pembekalan.xsisacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pembekalan.xsisacademy.entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer>  {
    
}
