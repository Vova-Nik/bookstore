package com.nikolenko.bookstore.rest;

import com.nikolenko.bookstore.model.Book;
import com.nikolenko.bookstore.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin
@Slf4j
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PostMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @PostMapping(value = "/remove")
    public String remove(@RequestBody Book book) {
        bookService.removeBook(book.getId());
        return "Deleted ";
    }

    @PostMapping(value = "/getbyid")
    public Book getbyid(@RequestBody Book book) {
        return  bookService.getBookById(book.getId());
    }

    @PostMapping(value = "/getall")
    public List<Book> getall() {
        return bookService.getAllBook();
    }

}
