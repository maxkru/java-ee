package ru.geekbrains.shop.service;

import ru.geekbrains.shop.persist.LineItem;
import ru.geekbrains.shop.persist.Product;

import javax.ejb.Stateful;
import java.util.List;


@Stateful
public class CartServiceImpl implements CartService {
    // TODO

    @Override
    public void addProductQty(Product product, String color, Integer qty) {

    }

    @Override
    public void removeProductQty(Product product, String color, Integer qty) {

    }

    @Override
    public List<LineItem> getAllLineItems() {
        return null;
    }
}
