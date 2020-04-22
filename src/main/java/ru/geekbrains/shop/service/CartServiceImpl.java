package ru.geekbrains.shop.service;

import ru.geekbrains.shop.service.repr.LineItem;
import ru.geekbrains.shop.service.repr.ProductRepr;

import javax.ejb.Stateful;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Stateful
public class CartServiceImpl implements CartService {

    private final Map<LineItem, Integer> map = new LinkedHashMap<>();

    @Override
    public void addProductQty(ProductRepr productRepr, String color, Integer qty) {
        LineItem item = new LineItem(productRepr, color, qty, BigDecimal.ZERO);
        int initQty = map.getOrDefault(item, 0);
        map.put(item, initQty + qty);
    }

    @Override
    public void removeProductQty(ProductRepr productRepr, String color, Integer qty) {
        LineItem item = new LineItem(productRepr, color, qty, BigDecimal.ZERO);
        int initQty = map.getOrDefault(item, 0);
        if (initQty <= qty)
            map.remove(item);
        else
            map.put(item, initQty - qty);
    }

    @Override
    public List<LineItem> getAllLineItems() {
        map.forEach(((lineItem, qty) -> {
            lineItem.setQty(qty);
            lineItem.setTotalPrice(lineItem.getProductRepr().getPrice().multiply(new BigDecimal(qty)));
        }));
        return new ArrayList<>(map.keySet());
    }
}
