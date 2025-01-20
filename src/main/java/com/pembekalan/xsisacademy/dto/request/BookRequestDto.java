package com.pembekalan.xsisacademy.dto.request;

import lombok.Data;

@Data
public class BookRequestDto {
    private Integer id;
    private Integer authorId;
    private Integer categoryId;
    private Integer publisherId;
    private String title;
    private String synopsis;
    private Integer publishedYear;
    private Integer stock;
}
