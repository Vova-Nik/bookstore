package com.nikolenko.bookstore.model;

import com.nikolenko.bookstore.dao.BookRepository;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "ORDERS")
@EqualsAndHashCode
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    @Setter(value= AccessLevel.NONE)
    private long id;

    @Column(nullable = false)
    private LocalDateTime created = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private  Client client;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Book> books;

}
