package com.pembekalan.xsisacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pembekalan.xsisacademy.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

    @Query(value = "SELECT b.* " +
                   "FROM books b " +
                   "JOIN authors a ON b.author_id = a.id " +
                   "JOIN categories c ON b.category_id = c.id " +
                   "JOIN publishers p ON b.publisher_id = p.id " +
                   "WHERE b.is_deleted = false " +
                   "AND a.is_deleted = false " +
                   "AND c.is_deleted = false " +
                   "AND p.is_deleted = false " +
                   "ORDER BY b.title ASC", nativeQuery = true)
    List<Book> getAllBooks();
}
