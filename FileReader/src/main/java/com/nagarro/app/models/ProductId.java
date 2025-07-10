package com.nagarro.app.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProductId {

	private int id;
	private String brand;

	@Override
	public String toString() {
		return "ProductId [id=" + id + ", brand=" + brand + "]";
	}

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

	public ProductId(int id, String brand) {
		super();
		this.id = id;
		this.brand = brand;
	}

	public ProductId() {
	}

}
