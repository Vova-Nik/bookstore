package com.nikolenko.bookstore.model;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="BOOKS")
@Data
public class Book {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "YEAR")
    private String issueYear;
    @Column(name = "PRICE")
    private BigDecimal price;

}
