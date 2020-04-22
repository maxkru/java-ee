package ru.geekbrains.shop.controller;

import ru.geekbrains.shop.service.CartService;
import ru.geekbrains.shop.service.repr.LineItem;
import ru.geekbrains.shop.service.repr.ProductRepr;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CartController implements Serializable {

    @EJB
    private CartService cartService;

    public List<LineItem> getAllLineItems() {
        return cartService.getAllLineItems();
    }

    public void addToCart(ProductRepr productRepr) {
        cartService.addProductQty(productRepr, "", 1);
    }

    public void removeFromCart(ProductRepr productRepr) {
        cartService.removeProductQty(productRepr, "", 1);
    }
}
