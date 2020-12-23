package com.nikolenko.bookstore.services;

import com.nikolenko.bookstore.dao.BookDAO;
import com.nikolenko.bookstore.dao.BookRepository;
import com.nikolenko.bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    @Transactional
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public Book updateBook(Book book) {
        bookRepository.deleteById(book.getId());
        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public boolean removeBook(long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Book getBookById(long id) {
       return  bookRepository.findById(id).get();
    }

    @Override
    @Transactional
    public List<Book> getAllBook() {
        return (List<Book>) bookRepository.findAll();
    }
}
