package com.pembekalan.xsisacademy.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pembekalan.xsisacademy.dto.request.AuthorRequestDto;
import com.pembekalan.xsisacademy.dto.response.AuthorResponseDto;
import com.pembekalan.xsisacademy.dto.response.PublisherResponseDto;
import com.pembekalan.xsisacademy.entity.Author;
import com.pembekalan.xsisacademy.service.AuthorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@Controller
@RequestMapping("/api/author")
public class AuthorController {
    
    @Autowired
    AuthorService authorService;

    private LinkedHashMap<String, Object> resultMap(Object object){
        LinkedHashMap<String, Object> resultMap  = new LinkedHashMap<>();
        resultMap.put("status", 200);
        resultMap.put("message", "Success");
        resultMap.put("data", object);
        return resultMap;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllAuthors() {
        List<AuthorResponseDto> authorResponseDtos = authorService.getAllAuthors();
        return new ResponseEntity<>(resultMap(authorResponseDtos), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorByid(@PathVariable Integer id) {
        AuthorResponseDto authorResponseDto = authorService.getAuthorById(id);
        return new ResponseEntity<>(resultMap(authorResponseDto), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> saveAuthor(@RequestBody AuthorRequestDto authorRequestDto) {
        //TODO: process POST request
        Author author = authorService.saveAuthor(authorRequestDto);
        return new ResponseEntity<>(resultMap(author), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Integer id, @RequestBody AuthorRequestDto authorRequestDto) {
        //TODO: process PUT request
        authorRequestDto.setId(id);
        Author author = authorService.saveAuthor(authorRequestDto);
        return new ResponseEntity<>(resultMap(author), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Integer id){
        authorService.deleteAuthorById(id);
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("status", 200);
        resultMap.put("message", "Success");
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
    
    
}
