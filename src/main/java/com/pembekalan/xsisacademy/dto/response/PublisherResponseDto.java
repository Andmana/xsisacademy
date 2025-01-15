package com.pembekalan.xsisacademy.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PublisherResponseDto {
    private Integer id;
    private String name;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updated_at;
    private boolean isDeleted;

}
