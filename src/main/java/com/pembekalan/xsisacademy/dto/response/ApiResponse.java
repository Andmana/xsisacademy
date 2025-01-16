package com.pembekalan.xsisacademy.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private Integer success;
    private String message;
    private T data;
}