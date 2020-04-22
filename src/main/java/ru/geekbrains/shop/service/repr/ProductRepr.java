package ru.geekbrains.shop.service.repr;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductRepr implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer categoryId;

    public ProductRepr() {

    }

    public ProductRepr(Integer id, String name, String description, BigDecimal price, Integer categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
