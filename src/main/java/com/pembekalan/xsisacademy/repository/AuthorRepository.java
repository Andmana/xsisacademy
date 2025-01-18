package com.pembekalan.xsisacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pembekalan.xsisacademy.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
    
    @Query(value = "select c from Author c where c.isDeleted = false order by c.name asc")
    List<Author> getAllAuthors();

    @Query("select a from Author a where a.isDeleted = false and (LOWER(a.name) like LOWER(concat('%', :name, '%')) or LOWER(a.name) = LOWER(:name)) order by a.name asc")
    List<Author> getAuthorsByName(@Param("name") String name);

}
