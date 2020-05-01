package ru.geekbrains.shop.service.repr;

import ru.geekbrains.shop.persist.User;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserRepr implements Serializable {

    private int id;
    private String name;
    private String password;
    private Set<UserRoleRepr> roles;

    public UserRepr() {

    }

    public UserRepr(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.roles = new HashSet<>();
        user.getRoles().forEach(role -> this.roles.add(new UserRoleRepr(role)));
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRoleRepr> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRoleRepr> roles) {
        this.roles = roles;
    }
}
