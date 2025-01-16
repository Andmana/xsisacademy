package com.pembekalan.xsisacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pembekalan.xsisacademy.entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer>  {
    
    @Query(value = "select c from Publisher c where c.isDeleted = false order by c.name asc")
    List<Publisher> getAllPublishers();
}
