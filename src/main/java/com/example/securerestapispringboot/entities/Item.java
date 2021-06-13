package com.example.securerestapispringboot.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {
    private @Id @GeneratedValue long id;
    //private @ManyToOne Order order;
    private double price;
    private String description;
    private String manufacturer;

    private Item() {
    }

    public Item(double price, String description, String manufacturer) {
        //this.order = order;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    @Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Item item = (Item) o;
		return Objects.equals(id, item.id) &&
			Objects.equals(price, item.price) &&
			Objects.equals(description, item.description) &&
			Objects.equals(manufacturer, item.manufacturer);
			//Objects.equals(order, item.order);
	}

    @Override
    public int hashCode() {
        return Objects.hash(id, price, description, manufacturer);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}
