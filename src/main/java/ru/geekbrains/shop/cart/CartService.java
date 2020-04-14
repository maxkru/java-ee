package ru.geekbrains.shop.cart;

import ru.geekbrains.shop.persist.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Named
@SessionScoped
public class CartService implements Serializable {
    private final Map<LineItem, Integer> lineItemQuantityMap;

    public CartService() {
        lineItemQuantityMap = new ConcurrentHashMap<>();
    }

    public void addProductQty(Product product, String color, Integer qty) {
        LineItem item = new LineItem(product, color);
        lineItemQuantityMap.put(item, qty + lineItemQuantityMap.getOrDefault(item, 0));
    }

    public void removeProductQty(Product product, String color, Integer qty) {
        LineItem item = new LineItem(product, color);
        int qtyCurr = lineItemQuantityMap.getOrDefault(item, 0);
        if (qty >= qtyCurr)
            lineItemQuantityMap.remove(item);
        else
            lineItemQuantityMap.put(item, qtyCurr - qty);
    }

    public List<LineItem> getAllLineItems() {
        lineItemQuantityMap.forEach(LineItem::setQty);
        lineItemQuantityMap.forEach(((item, qty) -> item.setTotalPrice(item.getProduct().getPrice().multiply(new BigDecimal(qty)))));
        return new ArrayList<>(lineItemQuantityMap.keySet());
    }
}
