package ru.geekbrains.shop.controller;

import ru.geekbrains.shop.persist.LineItem;
import ru.geekbrains.shop.persist.Product;
import ru.geekbrains.shop.service.CartService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class CartController implements Serializable {

    @Inject
    private CartService cartService;

    public List<LineItem> getAllLineItems() {
        return new ArrayList<>();
//        return cartService.getAllLineItems();
    }

    public void addToCart(Product product) {
//        cartService.addProductQty(product, "", 1);
    }

    public void removeFromCart(Product product) {

//        cartService.removeProductQty(product, "", 1);
    }
}
