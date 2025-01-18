package com.pembekalan.xsisacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pembekalan.xsisacademy.dto.request.BookRequestDto;
import com.pembekalan.xsisacademy.dto.response.ApiResponse;
import com.pembekalan.xsisacademy.dto.response.BookResponseDto;
import com.pembekalan.xsisacademy.entity.Book;
import com.pembekalan.xsisacademy.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
    
    @Autowired
    BookService bookService;

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<BookResponseDto>>> getAllBooks() {
        List<BookResponseDto> data = bookService.getAllBooks();
        return ResponseEntity.ok(new ApiResponse<>(200, "success", data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponseDto>> getBookById(@PathVariable Integer id) {
        BookResponseDto data = bookService.getBookById(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "success", data));
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<Book>> saveBook(@RequestBody BookRequestDto requestDto) {
        Book data = bookService.saveBook(requestDto);
        return ResponseEntity.ok(new ApiResponse<>(200, "success", data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> updateBook(@PathVariable Integer id, @RequestBody BookRequestDto requestDto) {
        requestDto.setId(id);
        Book data = bookService.saveBook(requestDto);
        return ResponseEntity.ok(new ApiResponse<>(200, "success", data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteBook(@PathVariable Integer id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "success", null));
    }
}
