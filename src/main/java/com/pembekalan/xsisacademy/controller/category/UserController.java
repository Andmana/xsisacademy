package com.pembekalan.xsisacademy.controller.category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pembekalan.xsisacademy.dto.request.UserRequestDto;
import com.pembekalan.xsisacademy.dto.response.UserResponseDto;
import com.pembekalan.xsisacademy.entity.User;
import com.pembekalan.xsisacademy.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    private ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @GetMapping("")
    public ModelAndView getAllUsers() {
        ModelAndView view = new ModelAndView("user/index");
        // List<UserRespoonseDto> userRespoonseDtos = new ArrayList<>();
        
        // for(User user : users){
            //     UserResponseDto userResponseDto = new UserResponseDto();
        //     userResponseDto.setName(user.getName());
        //     userResponseDto.setPhoneNumber(user.getPhoneNumber());
        //     userResponseDto.setAddress(user.getAddress());
        //     userResponseDtos.add(userResponseDto);
        // }


        List<UserResponseDto> ussResponseDtos = userService.getAllUsers();
        view.addObject("users", ussResponseDtos);
        view.addObject("title", "User Page");
        return view;
    }
    
    @GetMapping("/form")
    public ModelAndView userForm() {
        ModelAndView view = new ModelAndView("user/form");
        UserResponseDto userResponseDto = new UserResponseDto();
        view.addObject("user", userResponseDto);
        return view;
    }

    @PostMapping("save")
    public ModelAndView saveUser (@ModelAttribute UserRequestDto userRequestDto,  BindingResult result) {
        if(!result.hasErrors()){
            userService.saveUser(userRequestDto);
        }
        return new ModelAndView("redirect:/user");
        
    }
    
    @GetMapping("edit/{id}")
    public ModelAndView editUser(@PathVariable Integer id ) {
        ModelAndView view = new ModelAndView("user/form");
        UserResponseDto userResponseDto = userService.getUserById(id);
        view.addObject("user", userResponseDto);
        return view;
    }
    

    @GetMapping("delete/{id}")
    public ModelAndView deleteUser(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return new ModelAndView("redirect:/user");
    }
    

}
