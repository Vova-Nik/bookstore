package com.nikolenko.bookstore.services;

import com.nikolenko.bookstore.dao.BookRepository;
import com.nikolenko.bookstore.model.Book;
import com.nikolenko.bookstore.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

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
       Optional<Book> book =  bookRepository.findById(id);
        if(book.isEmpty()){
            return new Book();
        }
        return book.get();
    }

    @Override
    @Transactional
    public List<Book> getAllBook() {
        return (List<Book>) bookRepository.findAll();
    }


}
