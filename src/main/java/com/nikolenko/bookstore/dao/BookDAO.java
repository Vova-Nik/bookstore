package com.nikolenko.bookstore.dao;

import com.nikolenko.bookstore.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDAO {
     void addBook(Book book);
     void updateBook(Book book);
     boolean removeBook(long id);
     Book getBookById(long id);
     List<Book> getAllBook();
}
