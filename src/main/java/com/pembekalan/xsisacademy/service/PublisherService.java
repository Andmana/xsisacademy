package com.pembekalan.xsisacademy.service;

import java.util.List;

import com.pembekalan.xsisacademy.dto.request.PublisherRequestDto;
import com.pembekalan.xsisacademy.dto.response.PublisherResponseDto;
import com.pembekalan.xsisacademy.entity.Publisher;

public interface PublisherService {
    List<PublisherResponseDto> getAllPublishers();
    List<PublisherResponseDto> getPublishersByName(String name);

    PublisherResponseDto getPublisherById(Integer id);
    Publisher savePublisher(PublisherRequestDto requestDto);
    void deletePublisherById(Integer id);
}
