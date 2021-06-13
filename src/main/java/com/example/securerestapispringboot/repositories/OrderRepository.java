package com.example.securerestapispringboot.repositories;

import com.example.securerestapispringboot.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
