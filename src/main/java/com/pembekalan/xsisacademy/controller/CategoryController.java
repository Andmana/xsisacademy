package com.pembekalan.xsisacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping()
    public ResponseEntity<ApiResponse<List<CategoryResponseDto>>> getAllCategories() {
        try {
            List<CategoryResponseDto> data = categoryService.getAllCategories();
            return ResponseEntity.ok(new ApiResponse<>(200, "success", data));
        } catch (Exception e) {
            // Handle exception and return an appropriate error response
            ApiResponse<List<CategoryResponseDto>> errorResponse = new ApiResponse<>(404, "error: " + e.getMessage(), null);
            return ResponseEntity.status(404).body(errorResponse);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<CategoryResponseDto>>> getCategorisByName(@RequestParam(required = false) String name) {
        try {
            List<CategoryResponseDto> data = categoryService.getCategoriesByName(name);
            return ResponseEntity.ok(new ApiResponse<>(200, "success", data));
        } catch (Exception e) {
            ApiResponse<List<CategoryResponseDto>> errorResponse = new ApiResponse<>(404, "error: " + e.getMessage(), null);
            return ResponseEntity.status(404).body(errorResponse);
        }
    }

    @GetMapping("/{id}")    
    public ResponseEntity<ApiResponse<CategoryResponseDto>> getCategoryById(@PathVariable Integer id) {
        try {
            CategoryResponseDto data = categoryService.getCategoryById(id);
            return ResponseEntity.ok(new ApiResponse<>(200, "success", data));
        } catch (Exception e) {
            ApiResponse<CategoryResponseDto> errorResponse = new ApiResponse<>(404, "error: " + e.getMessage(), null);
            return ResponseEntity.status(404).body(errorResponse);
        }
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<?>> saveCategory(@RequestBody CategoryRequestDto requestDto) {
        try {
            Category data = categoryService.saveCategory(requestDto);
            return ResponseEntity.ok(new ApiResponse<>(200, "success", data));
        } catch (Exception e) {
            ApiResponse<CategoryRequestDto> errorResponse = new ApiResponse<>(404, "error: " + e.getMessage(), requestDto);
            return ResponseEntity.status(404).body(errorResponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> updateCategory(@PathVariable Integer id, @RequestBody CategoryRequestDto requestDto) {
        try {
            requestDto.setId(id);
            Category data = categoryService.saveCategory(requestDto);
            return ResponseEntity.ok(new ApiResponse<>(200, "success", data));
        } catch (Exception e) {
            ApiResponse<CategoryRequestDto> errorResponse = new ApiResponse<>(404, "error: " + e.getMessage(), requestDto);
            return ResponseEntity.status(404).body(errorResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteCategory(@PathVariable Integer id) {
        try {
            categoryService.deleteCategoryById(id);
            return ResponseEntity.ok(new ApiResponse<>(200, "success", null));
        } catch (Exception e) {
            ApiResponse<?> errorResponse = new ApiResponse<>(404, "error: " + e.getMessage(), e);
            return ResponseEntity.status(404).body(errorResponse);
        }
    }

}
