package ru.geekbrains.shop.service.repr;

import java.math.BigDecimal;
import java.util.Objects;

public class LineItem {

    private ProductRepr productRepr;
    private String color;
    private Integer qty;
    private BigDecimal totalPrice;

    public LineItem() {

    }

    public LineItem(ProductRepr productRepr, String color, Integer qty, BigDecimal totalPrice) {
        this.productRepr = productRepr;
        this.color = color;
        this.qty = qty;
        this.totalPrice = totalPrice;
    }

    public ProductRepr getProductRepr() {
        return productRepr;
    }

    public void setProductRepr(ProductRepr productRepr) {
        this.productRepr = productRepr;
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
        return productRepr.equals(lineItem.productRepr) &&
                color.equals(lineItem.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productRepr, color);
    }
}
