package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    List<Product> findByDeveloper(String name);

    List<Product> findByModel(String name);

    void update(int id, Product product);

    void remove(int id);

    int getSize();
}
