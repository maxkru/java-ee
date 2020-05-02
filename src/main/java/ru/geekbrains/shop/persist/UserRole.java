package ru.geekbrains.shop.persist;

import ru.geekbrains.shop.service.repr.UserRoleRepr;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public UserRole() {

    }

    public UserRole(UserRoleRepr repr) {
        this.id = repr.getId();
        this.name = repr.getName();
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
}
