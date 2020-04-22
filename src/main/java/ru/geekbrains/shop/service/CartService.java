package ru.geekbrains.shop.service;

import ru.geekbrains.shop.persist.LineItem;
import ru.geekbrains.shop.persist.Product;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CartService {

    void addProductQty(Product product, String color, Integer qty);

    void removeProductQty(Product product, String color, Integer qty);

    List<LineItem> getAllLineItems();
}
