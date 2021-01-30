package com.nikolenko.bookstore.dao;

import com.nikolenko.bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

}
