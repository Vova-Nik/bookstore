package com.nikolenko.bookstore.dao;

import com.nikolenko.bookstore.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class BookDAOImpl implements BookDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
        log.info("{} is persisted", book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
        log.info("{} is updated", book);
    }

    @Override
    public boolean removeBook(long id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.load(Book.class, id);
        if (book == null) {
            log.error("Book with id={} is not exist", id);
            return false;
        }
        session.delete(book);
        log.info("Book with id={} deleted", id);
        return true;
    }

    @Override
    public Book getBookById(long id) {
        Session session = sessionFactory.getCurrentSession();
        log.info("Book with id={} loaded", id);
        return session.load(Book.class, id);
    }

    @Override
    public List<Book> getAllBook() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> books =  session.createQuery("FROM boook", Book.class).list(); //1:15 in lesson
        log.info("Book list loaded");
        return books;
    }
}
