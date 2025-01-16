package com.pembekalan.xsisacademy.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pembekalan.xsisacademy.dto.request.BookRequestDto;
import com.pembekalan.xsisacademy.dto.response.BookResponseDto;
import com.pembekalan.xsisacademy.entity.Author;
import com.pembekalan.xsisacademy.entity.Book;
import com.pembekalan.xsisacademy.entity.Category;
import com.pembekalan.xsisacademy.entity.Publisher;
import com.pembekalan.xsisacademy.repository.AuthorRepository;
import com.pembekalan.xsisacademy.repository.BookRepository;
import com.pembekalan.xsisacademy.repository.CategoryRepository;
import com.pembekalan.xsisacademy.repository.PublisherRepository;
import com.pembekalan.xsisacademy.service.BookService;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    PublisherRepository publisherRepository;

    private ModelMapper modelMapper = new ModelMapper();


    @Override
    public List<BookResponseDto> getAllBooks() {
        // TODO Auto-generated method stub
        List<Book> books = bookRepository.getAllBooks();
        List<BookResponseDto> data = books.stream().map(book -> modelMapper.map(book, BookResponseDto.class)).collect(Collectors.toList());
        return data;
    }

    @Override
    public BookResponseDto getBookById(Integer id) {
        // TODO Auto-generated method stub
        Book book = bookRepository.findById(id).orElse(null);
        BookResponseDto data = modelMapper.map(book, BookResponseDto.class);
        return data;
    }

    @Override
    public Book saveBook(BookRequestDto requestDto) {
        // TODO Auto-generated method stub
        Author author = authorRepository.findById(requestDto.getAuthorId()).orElseThrow();
        Category category = categoryRepository.findById(requestDto.getCategoryId()).orElseThrow();
        Publisher publisher = publisherRepository.findById(requestDto.getPublisherId()).orElseThrow();
        Book data = modelMapper.map(requestDto, Book.class);
        data.setAuthor(author);
        data.setCategory(category);
        data.setPublisher(publisher);
        return bookRepository.save(data);
    }

    @Override
    public void deleteBookById(Integer id) {
        // TODO Auto-generated method stub
        Book data = bookRepository.findById(id).orElseThrow();
        if (data != null){
            data.setDeleted(true);
            bookRepository.save(data);
        }
    }
    
}
