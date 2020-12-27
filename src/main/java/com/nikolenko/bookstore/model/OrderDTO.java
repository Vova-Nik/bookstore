package com.nikolenko.bookstore.model;

import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class OrderDTO {
    private long client;
    private long[] books;

    private long id;
    private String created;
    private String clientFirstName;
    private String clientLastName;
    private String[] bookNames;

    public void setup(long id, LocalDateTime created,String clientFirstName, String clientLastName, List<Book> bookList){
        this.id = id;
        this.created = created.toString();
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        bookNames = new String[bookList.size()];
        int i=0;
        for (Book book:bookList) {
            bookNames[i] = book.getTitle() + ", by " + book.getAuthor();
            i++;
        }
    }
}
