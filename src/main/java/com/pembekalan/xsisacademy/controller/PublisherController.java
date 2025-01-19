package com.pembekalan.xsisacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<ApiResponse<List<PublisherResponseDto>>> getAllPublishers() {
        List<PublisherResponseDto> data = publisherService.getAllPublishers();
        return ResponseEntity.ok(new ApiResponse<>(200, "success", data));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<PublisherResponseDto>>> getPublishersByName(@RequestParam(required = false) String name) {
        List<PublisherResponseDto> data = publisherService.getPublishersByName(name);
        return ResponseEntity.ok(new ApiResponse<>(200, "success", data));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PublisherResponseDto>> getPublisherById(@PathVariable Integer id) {
        PublisherResponseDto data = publisherService.getPublisherById(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "success", data));
    }
    
    @PostMapping()
    public ResponseEntity<ApiResponse<Publisher>> savePublisher(@RequestBody PublisherRequestDto requestDto) {
        Publisher data = publisherService.savePublisher(requestDto);
        return ResponseEntity.ok(new ApiResponse<>(200, "success", data));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Publisher>> updatePublisher(@PathVariable Integer id, @RequestBody PublisherRequestDto requestDto) {
        requestDto.setId(id);
        Publisher data = publisherService.savePublisher(requestDto);
        return ResponseEntity.ok(new ApiResponse<>(200, "success", data));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePublisher(@PathVariable Integer id) {
        publisherService.deletePublisherById(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "success", null));
    }
    
    
}
