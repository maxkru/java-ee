package ru.geekbrains.shop.service;

import javax.ejb.Stateful;


@Stateful
public class CartServiceImpl {
////
//    public CartService() {
//
//    }
//
//    public void addProductQty(Product product, String color, Integer qty) {
//        LineItem item = new LineItem(product, color, qty, new BigDecimal("0"));
//        int index = cart.getItems().indexOf(item);
//        int qtyInit = index;
//    }

//    public void removeProductQty(Product product, String color, Integer qty) {
//        LineItem item = new LineItem(product, color);
//        int qtyCurr = lineItemQuantityMap.getOrDefault(item, 0);
//        if (qty >= qtyCurr)
//            lineItemQuantityMap.remove(item);
//        else
//            lineItemQuantityMap.put(item, qtyCurr - qty);
//    }
//
//    public List<LineItem> getAllLineItems() {
//        lineItemQuantityMap.forEach(LineItem::setQty);
//        lineItemQuantityMap.forEach(((item, qty) -> item.setTotalPrice(item.getProduct().getPrice().multiply(new BigDecimal(qty)))));
//        return new ArrayList<>(lineItemQuantityMap.keySet());
//    }
}
