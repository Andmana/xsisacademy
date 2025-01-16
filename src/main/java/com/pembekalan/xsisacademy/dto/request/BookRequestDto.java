package com.pembekalan.xsisacademy.dto.request;

import lombok.Data;

@Data
public class BookRequestDto {
    private Integer id;
    private String authoId;
    private String categoryId;
    private String publisheId;
    private String title;
    private String synopsis;
    private Integer publishedYear;
}
