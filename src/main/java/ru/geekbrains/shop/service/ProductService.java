package ru.geekbrains.shop.service;

import ru.geekbrains.shop.service.repr.ProductRepr;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductService {
    void insert(ProductRepr product);

    void delete(int id);

    void update(ProductRepr product);

    ProductRepr findById(int id);

    List<ProductRepr> findByCategory(int categoryId);

    List<ProductRepr> findAll();
}
