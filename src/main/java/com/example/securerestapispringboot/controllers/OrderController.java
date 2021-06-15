package com.example.securerestapispringboot.controllers;

import java.util.List;

import com.example.securerestapispringboot.entities.Order;
import com.example.securerestapispringboot.exceptions.OrderNotFoundException;
import com.example.securerestapispringboot.repositories.OrderRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class OrderController {


    private final OrderRepository repository;
    
    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/orders")
    List<Order> all() {
        return repository.findAll();
    }

    @PostMapping("/orders")
    Order newOrder(@RequestBody Order order) {
        return repository.save(order);
    }

    @GetMapping("/orders/{id}")
    Order getOrderById(@PathVariable long id) {
        return repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    @PutMapping("/orders/{id}")
    Order replaceOrder(@RequestBody Order newOrder, @PathVariable Long id) {

        return repository.findById(id).map(order -> {
            order.setOrderedItems(newOrder.getOrderedItems());
            order.setDescription(newOrder.getDescription());
            order.setPrice(newOrder.getPrice());
            return repository.save(order);
        }).orElseGet(() -> {
            newOrder.setId(id);
            return repository.save(newOrder);
        });
    }

    @DeleteMapping("/orders/{id}")
    void deleteItem(@PathVariable long id) {
        repository.deleteById(id);
    }
}
