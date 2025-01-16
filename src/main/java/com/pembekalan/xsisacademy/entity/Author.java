package com.pembekalan.xsisacademy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authors")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Author extends BaseEntity{

    public Author(String name, Integer publishedBooks) {
        this.name = name;
        this.publishedBooks = publishedBooks;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String name;

    private Integer publishedBooks;
}
