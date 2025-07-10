package com.nagarro.app.models;

public class Product {
	private int id;
	private String brand;
	private String color;
	private int size;
	private ProductType type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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
		return "Product{" + "id=" + id + ", brand='" + brand + '\'' + ", color='" + color + '\'' + ", size=" + size
				+ ", type=" + type + '}';
	}
}
