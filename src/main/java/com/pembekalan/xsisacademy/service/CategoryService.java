package com.pembekalan.xsisacademy.service;

import java.util.List;

import com.pembekalan.xsisacademy.dto.request.CategoryRequestDto;
import com.pembekalan.xsisacademy.dto.response.CategoryResponseDto;
import com.pembekalan.xsisacademy.entity.Category;

public interface CategoryService {
    List<CategoryResponseDto> getAllCategories();
    CategoryResponseDto getCategoryById(Integer id);
    Category saveCategory(CategoryRequestDto categoryRequestDto);
    void deleteCategoryById(Integer id);
}
