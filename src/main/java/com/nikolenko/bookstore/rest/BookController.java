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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(
            @RequestParam("title") String title,
            @RequestParam("author") String author,
            @RequestParam("issueYear") String issueYear,
            @RequestParam("price") String price
    ) {
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        book.setIssueYear(issueYear);
        book.setPrice(new BigDecimal(price));
        bookService.addBook(book);
        log.info("/add");
        return "Added " + title + " " + author + " " + issueYear + " " + price;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(
            @RequestParam("id") String id,
            @RequestParam("title") String title,
            @RequestParam("author") String author,
            @RequestParam("issueYear") String issueYear,
            @RequestParam("price") String price
    ) {
        Book book = new Book();
        book.setId(Long.parseLong(id));
        book.setTitle(title);
        book.setAuthor(author);
        book.setIssueYear(issueYear);
        BigDecimal pr = new BigDecimal(price);
        book.setPrice(pr);

        bookService.updateBook(book);
        log.debug("/update");
        return "Updated " + book.toString();
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String remove(@RequestParam("id") String id) {
        bookService.removeBook(Long.parseLong(id));
        log.debug("/remove");
        return "Deleted " + id;
    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.GET)
    public String getbyid(@RequestParam("id") long id) {
        Book book = bookService.getBookById(id);
        log.debug("/getbyid ID={}", id );
        return "/getbyid id = " + id + "</br>" + book.toString();
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public String getall() {
        List<Book> books = bookService.getAllBook();
        log.info("/getall");
        StringBuilder toReturn = new StringBuilder();
        for (Book book:
             books) {
            toReturn.append(book.toString()).append("</br>");
        }
        return toReturn.toString();
    }

}
