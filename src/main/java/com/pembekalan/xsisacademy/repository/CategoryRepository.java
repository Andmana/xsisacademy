package com.pembekalan.xsisacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pembekalan.xsisacademy.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    // @Query(value = "select * from categories order by updated_at desc", nativeQuery = true)
    // List<Category> getAllCategories();

    @Query(value = "select c from Category c order by c.updatedAt desc")
    List<Category> getAllCategories();
    
}