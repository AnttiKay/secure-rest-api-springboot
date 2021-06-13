package com.example.securerestapispringboot.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(long id) {
        super("Could not find item with id: " + id);
    }
}
