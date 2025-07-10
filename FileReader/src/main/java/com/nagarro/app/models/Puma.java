package com.nagarro.app.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
public class Puma {

	@EmbeddedId
	private ProductId id;
	private String color;
	private int size;
	private ProductType type;

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

	@Override
	public String toString() {
		return "Puma [id=" + id + ", color=" + color + ", size=" + size + ", type=" + type + "]";
	}

	public Puma(ProductId id, String color, int size, ProductType type) {
		super();
		this.id = id;
		this.color = color;
		this.size = size;
		this.type = type;
	}

	public Puma() {
	}

}
