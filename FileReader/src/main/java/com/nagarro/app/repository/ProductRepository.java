package com.nagarro.app.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nagarro.app.models.Product;

public class ProductRepository {

    public static ProductRepository instance = null;
    private static Integer counter = 0;
    public HashMap<Integer, Product> map = new HashMap<>();

    private ProductRepository() {};

    public static synchronized ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }

    public Product save(Product product) {
        if (product.getId() == 0) {
            product.setId(++counter);
        }
        map.put(product.getId(), product);
        return product;
    }

    public void show() {
        System.out.println(map);
    }

    public List<Product> findAll() {
        this.show();
        return new ArrayList<>(map.values());
    }
}