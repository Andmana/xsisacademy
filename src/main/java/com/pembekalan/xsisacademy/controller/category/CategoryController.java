package com.pembekalan.xsisacademy.controller.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pembekalan.xsisacademy.entity.Category;
import com.pembekalan.xsisacademy.repository.CategoryRepository;

import groovy.lang.Binding;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository; 

    @GetMapping("")
    public ModelAndView getAllCategories(){
        ModelAndView view = new ModelAndView("category/index");
        String title = "Category Page";
        List<Category> categories = categoryRepository.getAllCategories();
        view.addObject("title", title);
        view.addObject("categories", categories);
        return view; 
    }

    @GetMapping("/form")
    public ModelAndView form() {
        Category category = new Category();
        ModelAndView view = new ModelAndView("category/form");
        view.addObject("category", category);
        return view;
    }

    @PostMapping("/store")
    public ModelAndView save(@ModelAttribute Category category, BindingResult result) {
        //TODO: process POST request
        // System.out.println("\n\n\n\n");
        // System.out.println(String.valueOf(category));
        // System.out.println(String.valueOf(result));
        // System.out.println("\n\n\n\n");
        if(!result.hasErrors()){
            categoryRepository.save(category);
        }

        return new ModelAndView("redirect:/category");
    }
    
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView view = new ModelAndView("category/form");
        Category category = categoryRepository.findById(id).orElse(null);
        view.addObject("category", category);
        return view;
    }

    @GetMapping("delete/{id}")
    public ModelAndView delete(@PathVariable Integer id){
        Category category = categoryRepository.findById(id).orElse(null);
        categoryRepository.deleteById(category.getId());
        return new ModelAndView("redirect:/category");
    }
    
}
