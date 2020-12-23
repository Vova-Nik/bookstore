package com.nikolenko.bookstore.services;

import com.nikolenko.bookstore.model.Book;

import java.util.List;

public interface BookService {

        Book addBook(Book book);
        Book updateBook(Book book);
        boolean removeBook(long id);
        Book getBookById(long id);
        List<Book> getAllBook();
}
