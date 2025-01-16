package com.pembekalan.xsisacademy.dto.response;

import java.util.Locale.Category;

import lombok.Data;

@Data
public class BookResponseDto {
    private Integer id;
    private String authorName;
    private Category category;
    private String publisherName;
    private String title;
    private String synopsis;
    private Integer publishedYear;
}
