package ru.geekbrains.shop.service.repr;

import ru.geekbrains.shop.persist.UserRole;

import java.io.Serializable;

public class UserRoleRepr implements Serializable {

    private int id;
    private String name;

    public UserRoleRepr() {

    }

    public UserRoleRepr(UserRole role) {
        this.id = role.getId();
        this.name = role.getName();
    }

    public int getId() {
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
}
