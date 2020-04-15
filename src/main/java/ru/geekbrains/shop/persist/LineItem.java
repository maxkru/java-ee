package ru.geekbrains.shop.persist;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Product product;

    @Column
    private String color;

    @Column
    private Integer qty;

    @Column
    private BigDecimal totalPrice;

    public LineItem() {

    }

    public LineItem(Product product, String color, Integer qty, BigDecimal totalPrice) {
        this.product = product;
        this.color = color;
        this.qty = qty;
        this.totalPrice = totalPrice;
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
