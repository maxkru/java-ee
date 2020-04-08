package ru.geekbrains.shop.persist;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class ProductRepository {

    private Connection connection;

    private List<Product> products;

    private int nextId;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "Раз", "РАЗРАЗ", new BigDecimal("1000")));
        products.add(new Product(2, "Два", "ДВАДВА", new BigDecimal("2300.132")));

        nextId = products.size() + 1;
    }


    public void insert(Product product) {
        product.setId(nextId++);
        products.add(product);
    }

    public void delete(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                break;
            }
        }
    }

    public List<Product> findAll() {
        return products;
    }

    public void update(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(product.getId())) {
                products.remove(i);
                products.add(i, product);
                break;
            }
        }
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
