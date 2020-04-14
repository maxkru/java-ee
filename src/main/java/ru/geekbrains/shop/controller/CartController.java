package ru.geekbrains.shop.controller;

import ru.geekbrains.shop.cart.CartService;
import ru.geekbrains.shop.cart.LineItem;
import ru.geekbrains.shop.persist.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CartController implements Serializable {

    @Inject
    private CartService cartService;

    public List<LineItem> getAllLineItems() {
        return cartService.getAllLineItems();
    }

    public void addToCart(Product product) {
        cartService.addProductQty(product, "", 1);
    }

    public void removeFromCart(Product product) {
        cartService.removeProductQty(product, "", 1);
    }
}
