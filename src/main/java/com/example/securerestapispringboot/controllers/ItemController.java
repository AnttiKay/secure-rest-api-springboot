package com.example.securerestapispringboot.controllers;

import java.util.List;

import com.example.securerestapispringboot.entities.Item;
import com.example.securerestapispringboot.exceptions.ItemNotFoundException;
import com.example.securerestapispringboot.repositories.ItemRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ItemController {
    private final ItemRepository repository;

    public ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/items")
    List<Item> all() {
        return repository.findAll();
    }

    @PostMapping("/items")
    Item newItem(@RequestBody Item item) {
        return repository.save(item);
    }

    @GetMapping("/items/{id}")
    Item getItemById(@PathVariable long id) {
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PutMapping("/items/{id}")
    Item replaceEmployee(@RequestBody Item newItem, @PathVariable Long id) {

        return repository.findById(id).map(item -> {
            item.setPrice(newItem.getPrice());
            item.setManufacturer(newItem.getManufacturer());
            item.setDescription(newItem.getDescription());
            item.setOrder(newItem.getOrder());
            return repository.save(item);
        }).orElseGet(() -> {
            newItem.setId(id);
            return repository.save(newItem);
        });
    }

    @DeleteMapping("/items/{id}")
    void deleteItem(@PathVariable long id) {
        repository.deleteById(id);
    }

}
