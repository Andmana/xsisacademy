package com.pembekalan.xsisacademy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Book extends BaseEntity{

    public Book(Author author, Category category, Publisher publisher, String title, String synopsis, Integer publishedYear, Integer stock) {
        this.author = author;
        this.category = category;
        this.publisher = publisher;
        this.title = title;
        this.synopsis = synopsis;
        this.publishedYear = publishedYear;
        this.stock = stock;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false) // FK in books table
    private Author author;

    // Many-to-one relationship with Category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false) // FK in books table
    private Category category;

    // Many-to-one relationship with Publisher
    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false) // FK in books table
    private Publisher publisher;

    private String title;

    @Column(columnDefinition = "TEXT") // For storing long text
    private String synopsis;

    private Integer publishedYear;

    private Integer stock;


}
