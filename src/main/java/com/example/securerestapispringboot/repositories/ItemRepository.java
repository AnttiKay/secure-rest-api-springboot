package com.example.securerestapispringboot.repositories;

import com.example.securerestapispringboot.entities.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>{
    
}
