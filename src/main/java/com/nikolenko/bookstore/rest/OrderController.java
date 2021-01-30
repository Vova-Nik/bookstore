package com.nikolenko.bookstore.rest;

import com.nikolenko.bookstore.model.Order;
import com.nikolenko.bookstore.model.OrderDTO;
import com.nikolenko.bookstore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@Service
public class OrderController {

    OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/add")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @PostMapping("/order/update")
    public Order updateClient(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    @PostMapping("/order/remove")
    public Order removeClient(@RequestBody Order order){
        long id = order.getId();
        if(id<=0){
            return new Order();
        }
        orderService.removeOrder(order.getId());
        return new Order();
    }

    @PostMapping("/order/getbyid")
    public Order getClientById(@RequestBody Order order){
        long id = order.getId();
        if(id<=0){
            return new Order();
        }
        return orderService.getOrderById(order.getId());
    }

    @PostMapping(value = "/order/getall")
    public List<OrderDTO> getall() {
        return orderService.getAllOrder();
    }

    @PostMapping(value = "/order/create")
    public Order create(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO.getClient(), orderDTO.getBooks());
    }

}

