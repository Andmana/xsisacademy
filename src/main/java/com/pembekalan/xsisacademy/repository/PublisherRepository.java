package com.pembekalan.xsisacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pembekalan.xsisacademy.entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer>  {
    
    @Query(value = "select c from Publisher c where c.isDeleted = false order by c.name asc")
    List<Publisher> getAllPublishers();

    @Query("select p from Publisher p where p.isDeleted = false and (LOWER(p.name) like LOWER(concat('%', :name, '%')) or LOWER(p.name) = LOWER(:name)) order by p.name asc")
    List<Publisher> getPublishersByName(@Param("name") String name);
}
