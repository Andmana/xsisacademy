package com.pembekalan.xsisacademy.controller.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pembekalan.xsisacademy.entity.Category;
import com.pembekalan.xsisacademy.repository.CategoryRepository;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository; 

    @GetMapping("")
    public ModelAndView getAllCategories(){
        ModelAndView view = new ModelAndView("category/index");
        String title = "Category Page";
        List<Category> categories = categoryRepository.findAll();
        view.addObject("title", title);
        view.addObject("categories", categories);
        return view; 
    }

    @GetMapping("/form")
    public ModelAndView form() {
        ModelAndView view = new ModelAndView("category/form");
        return view;
    }
    
}
