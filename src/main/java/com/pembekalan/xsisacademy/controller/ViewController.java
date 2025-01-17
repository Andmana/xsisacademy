package com.pembekalan.xsisacademy.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.pembekalan.xsisacademy.dto.response.CategoryResponseDto;
import com.pembekalan.xsisacademy.utility.ApiEndpoints;


@Controller
public class ViewController {

    RestTemplate restTemplate = new RestTemplate();
    
    @GetMapping("/author")
    public String getAllAuthor(Model model) {
        String title = "Author Page ";
        Map response = restTemplate.getForObject(ApiEndpoints.AUTHOR, Map.class);
        model.addAttribute("authors", response.get("data"));
        model.addAttribute("title", title);
        return "author/index";
    }

    

    @GetMapping("/book")
    public String getAllBooks(Model model) {
        String title = "Book Page ";
        Map response = restTemplate.getForObject(ApiEndpoints.BOOK, Map.class);
        model.addAttribute("books", response.get("data"));
        model.addAttribute("title", title);
        return "book/index";
    }

    @GetMapping("/category")
    public String getAllCategories(Model model) {
        String title = "Category Page ";
        Map response = restTemplate.getForObject(ApiEndpoints.CATEGORY, Map.class);
        model.addAttribute("categories", response.get("data"));
        model.addAttribute("title", title);
        return "category/index";
    }
    
    @GetMapping("/publisher")
    public String getAllPublishers(Model model) {
        String title = "Publishers Page ";
        Map response = restTemplate.getForObject(ApiEndpoints.PUBLISHER, Map.class);
        model.addAttribute("publishers", response.get("data"));
        model.addAttribute("title", title);
        return "publisher/index";
    }
    
    @GetMapping("/user")
    public String getAllUser(Model model) {
        String title = "User Page ";
        Map response = restTemplate.getForObject(ApiEndpoints.USER, Map.class);
        model.addAttribute("users", response.get("data"));
        model.addAttribute("title", title);
        return "user/index";
    }

}
