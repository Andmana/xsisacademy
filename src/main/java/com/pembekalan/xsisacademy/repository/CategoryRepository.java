package com.pembekalan.xsisacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pembekalan.xsisacademy.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    // @Query(value = "select * from categories order by updated_at desc", nativeQuery = true)
    // List<Category> getAllCategories();

    @Query(value = "select c from Category c where c.isDeleted = false order by c.name asc")
    List<Category> getAllCategories();

    @Query("select c from Category c where c.isDeleted = false and (LOWER(c.name) like LOWER(concat('%', :name, '%')) or LOWER(c.name) = LOWER(:name)) order by c.name asc")
    List<Category> getCategoriesByName(@Param("name") String name);
}