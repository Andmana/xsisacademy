package com.pembekalan.xsisacademy.dto.request;

import lombok.Data;

@Data
public class AuthorResponseDto {
    private Integer Id;
    private String name;
    private Integer publishedBooks;
}
