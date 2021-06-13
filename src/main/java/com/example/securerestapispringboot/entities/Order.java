package com.example.securerestapispringboot.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "ItemOrder")
public class Order {
    private @Id @GeneratedValue long id;
    private @OneToMany List<Item> orderedItems = new ArrayList<>();

    private String description;
    private double price;
    
    private Order(){}

    public Order(List<Item> orderedItems, String description) {
        this.orderedItems = orderedItems;
        this.description = description;
    }

    @Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Order order = (Order) o;
		return Objects.equals(id, order.id) &&
			Objects.equals(price, order.price) &&
			Objects.equals(description, order.description) &&
			Objects.equals(orderedItems, order.orderedItems);
	}

    @Override
    public int hashCode() {
        return Objects.hash(id, price, description, orderedItems);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Item> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<Item> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
