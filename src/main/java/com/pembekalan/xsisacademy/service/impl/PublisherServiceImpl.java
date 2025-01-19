package com.pembekalan.xsisacademy.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pembekalan.xsisacademy.dto.request.PublisherRequestDto;
import com.pembekalan.xsisacademy.dto.response.AuthorResponseDto;
import com.pembekalan.xsisacademy.dto.response.PublisherResponseDto;
import com.pembekalan.xsisacademy.entity.Author;
import com.pembekalan.xsisacademy.entity.Publisher;
import com.pembekalan.xsisacademy.repository.PublisherRepository;
import com.pembekalan.xsisacademy.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    PublisherRepository publisherRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PublisherResponseDto> getAllPublishers() {
        // TODO Auto-generated method stub
        List<Publisher> publishers = publisherRepository.getAllPublishers();
        List<PublisherResponseDto> data = publishers.stream().map(publisher -> modelMapper.map(publisher, PublisherResponseDto.class)).collect(Collectors.toList());
        return data;
    }

    @Override
    public List<PublisherResponseDto> getPublishersByName(String name) {
        // TODO Auto-generated method stub
        
        List<Publisher> publishers = name == null? publisherRepository.getAllPublishers() :  publisherRepository.getPublishersByName(name);
        List<PublisherResponseDto> data = publishers.stream().map(publisher -> modelMapper.map(publisher, PublisherResponseDto.class)).collect(Collectors.toList());
        return data;
    }

    @Override
    public PublisherResponseDto getPublisherById(Integer id) {
        // TODO Auto-generated method stub
        Publisher publisher = publisherRepository.findById(id).orElse(null);
        PublisherResponseDto data = modelMapper.map(publisher, PublisherResponseDto.class);
        return data;
    }

    @Override
    public Publisher savePublisher(PublisherRequestDto requestDto) {
        // TODO Auto-generated method stub
        Publisher data = modelMapper.map(requestDto, Publisher.class);
        return publisherRepository.save(data);
    }

    @Override
    public void deletePublisherById(Integer id) {
        // TODO Auto-generated method stub
        Publisher data = publisherRepository.findById(id).orElse(null);
        if (data != null){
            data.setDeleted(true);
            publisherRepository.save(data);
        }
    }
    
}
