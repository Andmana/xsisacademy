package com.pembekalan.xsisacademy.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pembekalan.xsisacademy.dto.request.CategoryRequestDto;
import com.pembekalan.xsisacademy.dto.response.ApiResponse;
import com.pembekalan.xsisacademy.dto.response.CategoryResponseDto;
import com.pembekalan.xsisacademy.entity.Category;
import com.pembekalan.xsisacademy.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> getAllCategories(){
        List<CategoryResponseDto> data = categoryService.getAllCategories();
        return new ResponseEntity<>(new ApiResponse<>(200, "success", data), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id){
        CategoryResponseDto data = categoryService.getCategoryById(id);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", data), HttpStatus.OK);
    } 

    @PostMapping("/")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryRequestDto requestDto){
        Category data = categoryService.saveCategory(requestDto);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", data), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer id, @RequestBody CategoryRequestDto requestDto){
        requestDto.setId(id);
        Category data = categoryService.saveCategory(requestDto);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", data), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", null), HttpStatus.OK);

    }
}
