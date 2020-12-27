package com.nikolenko.bookstore.dao;


import com.nikolenko.bookstore.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long> {
}
