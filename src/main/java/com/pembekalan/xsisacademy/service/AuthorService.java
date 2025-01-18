package com.pembekalan.xsisacademy.service;

import java.util.List;

import com.pembekalan.xsisacademy.dto.request.AuthorRequestDto;
import com.pembekalan.xsisacademy.dto.response.AuthorResponseDto;
import com.pembekalan.xsisacademy.entity.Author;

public interface AuthorService {
    List<AuthorResponseDto> getAllAuthors();
    List<AuthorResponseDto> getAuthorsByName(String name);
    AuthorResponseDto getAuthorById(Integer id);
    Author saveAuthor(AuthorRequestDto requestDto);
    void deleteAuthorById(Integer id);
}
