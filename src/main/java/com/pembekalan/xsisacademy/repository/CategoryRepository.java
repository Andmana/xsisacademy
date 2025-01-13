package com.pembekalan.xsisacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pembekalan.xsisacademy.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    
}