package com.pembekalan.xsisacademy.dto.response;

import java.util.Locale.Category;

import lombok.Data;

@Data
public class BookResponseDto {
    private Integer id;
    private AuthorResponseDto author;
    private CategoryResponseDto category;
    private PublisherResponseDto publisher;
    private String title;
    private String synopsis;
    private Integer publishedYear;
}
