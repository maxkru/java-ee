package ru.geekbrains.shop.cart;

import ru.geekbrains.shop.persist.Product;

import java.math.BigDecimal;
import java.util.Objects;

public class LineItem {
    private Product product;
    private String color;
    private Integer qty;
    private BigDecimal totalPrice;

    public LineItem() {

    }

    public LineItem(Product product, String color) {
        this.product = product;
        this.color = color;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return product.equals(lineItem.product) &&
                color.equals(lineItem.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, color);
    }
}
