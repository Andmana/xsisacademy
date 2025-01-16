package com.pembekalan.xsisacademy.service;

import java.util.List;

import com.pembekalan.xsisacademy.dto.request.BookRequestDto;
import com.pembekalan.xsisacademy.dto.response.BookResponseDto;
import com.pembekalan.xsisacademy.entity.Book;

public interface BookService {
    List<BookResponseDto> getAllBooks();
    BookResponseDto getBookById(Integer id);
    Book saveBook(BookRequestDto requestDto);
    void deleteBookById(Integer id);
}
