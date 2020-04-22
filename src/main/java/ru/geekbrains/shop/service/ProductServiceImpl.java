package ru.geekbrains.shop.service;

import ru.geekbrains.shop.persist.Product;
import ru.geekbrains.shop.persist.repository.ProductRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ProductServiceImpl implements ProductService {

    @EJB
    private ProductRepository repository;

    @Override
    public void insert(Product product) {
        repository.insert(product);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public void update(Product product) {
        repository.update(product);
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> findByCategory(int categoryId) {
        return repository.findByCategory(categoryId);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }
}
