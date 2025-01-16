package com.pembekalan.xsisacademy.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pembekalan.xsisacademy.dto.request.CategoryRequestDto;
import com.pembekalan.xsisacademy.dto.response.CategoryResponseDto;
import com.pembekalan.xsisacademy.entity.Category;
import com.pembekalan.xsisacademy.repository.CategoryRepository;
import com.pembekalan.xsisacademy.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        // TODO Auto-generated method stub
        List<Category> categories = categoryRepository.getAllCategories();
        List<CategoryResponseDto> data = categories.stream().map(category -> modelMapper.map(category, CategoryResponseDto.class)).collect(Collectors.toList());
        return data;
    }

    @Override
    public CategoryResponseDto getCategoryById(Integer id) {
        // TODO Auto-generated method stub
        Category category = categoryRepository.findById(id).orElse(null);
        CategoryResponseDto data = modelMapper.map(category, CategoryResponseDto.class);
        return data;
    }

    @Override
    public Category saveCategory(CategoryRequestDto requestDto) {
        // TODO Auto-generated method stub
        Category data = modelMapper.map(requestDto, Category.class);
        return categoryRepository.save(data);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        // TODO Auto-generated method stub
        Category data = categoryRepository.findById(id).orElse(null);
        if (data != null){
            data.setDeleted(true);
            categoryRepository.save(data);
        }
    }
    
}
