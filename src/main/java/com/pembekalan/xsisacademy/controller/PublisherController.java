package com.pembekalan.xsisacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pembekalan.xsisacademy.dto.request.PublisherRequestDto;
import com.pembekalan.xsisacademy.dto.response.ApiResponse;
import com.pembekalan.xsisacademy.dto.response.PublisherResponseDto;
import com.pembekalan.xsisacademy.entity.Publisher;
import com.pembekalan.xsisacademy.service.PublisherService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {
    
    @Autowired
    PublisherService publisherService;

    @GetMapping("")
    public ResponseEntity<?> getAllPublishers(){
        List<PublisherResponseDto> data = publisherService.getAllPublishers();
        return new ResponseEntity<>(new ApiResponse<>(200, "success", data), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPublisherById(@PathVariable Integer id){
        PublisherResponseDto data = publisherService.getPublisherById(id);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", data), HttpStatus.OK);
    } 

    @PostMapping("/")
    public ResponseEntity<?> savePublisher(@RequestBody PublisherRequestDto requestDto){
        Publisher data = publisherService.savePublisher(requestDto);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", data), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePublisher(@PathVariable Integer id, @RequestBody PublisherRequestDto requestDto){
        requestDto.setId(id);
        Publisher data = publisherService.savePublisher(requestDto);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", data), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePublisher(@PathVariable Integer id){
        publisherService.deletePublisherById(id);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", null), HttpStatus.OK);

    }
    
}
