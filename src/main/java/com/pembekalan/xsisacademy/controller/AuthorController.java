package com.pembekalan.xsisacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pembekalan.xsisacademy.dto.request.AuthorRequestDto;
import com.pembekalan.xsisacademy.dto.response.ApiResponse;
import com.pembekalan.xsisacademy.dto.response.AuthorResponseDto;
import com.pembekalan.xsisacademy.entity.Author;
import com.pembekalan.xsisacademy.service.AuthorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/author")
public class AuthorController {
    
    @Autowired
    AuthorService authorService;

    @GetMapping("")
    public ResponseEntity<?> getAllAuthors(){
        List<AuthorResponseDto> data = authorService.getAllAuthors();
        return new ResponseEntity<>(new ApiResponse<>(200, "success", data), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable Integer id){
        AuthorResponseDto data = authorService.getAuthorById(id);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", data), HttpStatus.OK);
    } 

    @PostMapping("/")
    public ResponseEntity<?> saveAuthor(@RequestBody AuthorRequestDto requestDto){
        Author data = authorService.saveAuthor(requestDto);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", data), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Integer id, @RequestBody AuthorRequestDto requestDto){
        requestDto.setId(id);
        Author data = authorService.saveAuthor(requestDto);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", data), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Integer id){
        authorService.deleteAuthorById(id);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", null), HttpStatus.OK);

    }
    
    
}
