package com.nikolenko.bookstore.services;

import com.nikolenko.bookstore.dao.OrderRepository;
import com.nikolenko.bookstore.model.Book;
import com.nikolenko.bookstore.model.Order;
import com.nikolenko.bookstore.model.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    BookService bookService;
    ClientService clientService;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        orderRepository.deleteById(order.getId());
        return orderRepository.save(order);
    }

    @Override
    public boolean removeOrder(long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Order getOrderById(long id) {
        return orderRepository.findById(id).orElse(new Order());
    }

    @Override
    public Order createOrder(long clientId, long[] bookIds) {
        Order order = new Order();
        order.setClient(clientService.getClientById(clientId));
        List<Book> books = new ArrayList<>();
        for (long id :
                bookIds) {
            Book book = bookService.getBookById(id);
            books.add(book);
        }
        order.setBooks(books);
        return addOrder(order);
    }

    @Override
    public List<OrderDTO> getAllOrder() {
        List<Order> orders = (List<Order>) orderRepository.findAll();
        List<OrderDTO> dtos = new ArrayList<>();

        for (Order order : orders
        ) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setup(order.getId(), order.getCreated(), order.getClient().getFirstName(), order.getClient().getLastName(), order.getBooks());
            dtos.add(orderDTO);
        }
        return dtos;
    }
}
