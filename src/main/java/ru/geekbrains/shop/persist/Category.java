package ru.geekbrains.shop.persist;

import javax.validation.constraints.NotEmpty;

public class Category {

    private Integer id;

    @NotEmpty(message = "Имя категории не должно быть пустым")
    private String name;

    private String description;

    public Category() {

    }

    public Category(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
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
}
