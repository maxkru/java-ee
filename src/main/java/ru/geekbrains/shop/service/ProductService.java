package ru.geekbrains.shop.service;

import ru.geekbrains.shop.persist.Product;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductService {

    void insert(Product product);

    void delete(int id);

    void update(Product product);

    Product findById(int id);

    List<Product> findByCategory(int categoryId);

    List<Product> findAll();
}
