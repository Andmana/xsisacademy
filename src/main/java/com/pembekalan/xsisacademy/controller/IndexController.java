package com.pembekalan.xsisacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/home")
public class IndexController {
    
    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("home/index");
        String name = "Fanny";
        view.addObject("testingValue", name);
        return view;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView view = new ModelAndView("create");
        String description = "Create Page";
        view.addObject("description", description);
        return view;
    }
    
    @GetMapping("/edit")
    public ModelAndView edit(){
        ModelAndView view = new ModelAndView("edit");
        String description = "eidt Page";
        view.addObject("description", description);
        return view;
    }
}
