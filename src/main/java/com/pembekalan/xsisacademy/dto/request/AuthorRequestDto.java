package com.pembekalan.xsisacademy.dto.request;

import lombok.Data;

@Data
public class AuthorRequestDto {
    private Integer Id;
    private String name;
    private Integer publishedBooks;
}
