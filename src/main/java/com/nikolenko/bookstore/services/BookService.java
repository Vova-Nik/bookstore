package com.nikolenko.bookstore.services;

import com.nikolenko.bookstore.model.Book;

import java.util.List;

public interface BookService {

        void addBook(Book book);
        void updateBook(Book book);
        boolean removeBook(long id);
        Book getBookById(long id);
        List<Book> getAllBook();
}
