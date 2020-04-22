package ru.geekbrains.shop.service;

import ru.geekbrains.shop.persist.Product;
import ru.geekbrains.shop.persist.repository.CategoryRepository;
import ru.geekbrains.shop.persist.repository.ProductRepository;
import ru.geekbrains.shop.service.repr.ProductRepr;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ProductServiceImpl implements ProductService {

    @EJB
    private ProductRepository repository;

    @EJB
    private CategoryRepository categoryRepository;

    @Override
    public void insert(ProductRepr repr) {
        repository.insert(fromRepr(repr));
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public void update(ProductRepr repr) {
        repository.update(fromRepr(repr));
    }

    @Override
    public ProductRepr findById(int id) {
        Product product = repository.findById(id);
        return product == null ? null : toRepr(product);
    }

    @Override
    public List<ProductRepr> findByCategory(int categoryId) {
        return repository.findByCategory(categoryId).stream()
                .map(this::toRepr)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductRepr> findAll() {
        return repository.findAll().stream()
                .map(this::toRepr)
                .collect(Collectors.toList());
    }

    private Product fromRepr(ProductRepr repr) {
        return new Product(
                repr.getId(),
                repr.getName(),
                repr.getDescription(),
                repr.getPrice(),
                categoryRepository.findById(repr.getCategoryId())
        );
    }

    private ProductRepr toRepr(Product product) {
        return new ProductRepr(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }
}
