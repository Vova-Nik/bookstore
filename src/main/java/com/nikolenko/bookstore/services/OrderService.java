package com.nikolenko.bookstore.services;

import com.nikolenko.bookstore.model.Order;
import com.nikolenko.bookstore.model.OrderDTO;

import java.util.List;

public interface OrderService {
    Order addOrder(Order order);

    Order updateOrder(Order order);

    boolean removeOrder(long id);

    Order getOrderById(long id);

    List<OrderDTO> getAllOrder();

    Order createOrder(long clientId, long[] bookId);
}
