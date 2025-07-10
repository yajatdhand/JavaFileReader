package com.nagarro.app.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
public class Nike {

	@EmbeddedId
	private ProductId id;
	private String color;
	private int size;
	private ProductType type;
	private double price;

	public ProductId getId() {
		return id;
	}

	public void setId(ProductId id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Nike [id=" + id + ", color=" + color + ", size=" + size + ", type=" + type + ", price=" + price + "]";
	}

	public Nike(ProductId id, String color, int size, ProductType type, double price) {
		super();
		this.id = id;
		this.color = color;
		this.size = size;
		this.type = type;
		this.price = price;
	}

	public Nike() {
	}
}
