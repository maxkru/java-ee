package ru.geekbrains.shop.service;

import ru.geekbrains.shop.service.repr.LineItem;
import ru.geekbrains.shop.service.repr.ProductRepr;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CartService {

    void addProductQty(ProductRepr productRepr, String color, Integer qty);

    void removeProductQty(ProductRepr productRepr, String color, Integer qty);

    List<LineItem> getAllLineItems();
}
