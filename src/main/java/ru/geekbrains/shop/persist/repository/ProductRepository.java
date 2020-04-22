package ru.geekbrains.shop.persist.repository;

import ru.geekbrains.shop.persist.Product;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductRepository {
    void insert(Product product);

    void delete(int id);

    List<Product> findAll();

    void update(Product product);

    Product findById(int id);

    List<Product> findByCategory(int categoryId);

}
