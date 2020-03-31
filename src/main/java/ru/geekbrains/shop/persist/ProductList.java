package ru.geekbrains.shop.persist;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private List<Product> list;

    public ProductList() {
        list = new ArrayList<>();
    }

    public List<Product> getList() {
        return list;
    }

    public Product findById(int id) {
        for (Product p : list) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
