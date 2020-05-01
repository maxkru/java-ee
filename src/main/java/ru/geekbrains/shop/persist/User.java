package ru.geekbrains.shop.persist;

import ru.geekbrains.shop.service.repr.UserRepr;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", unique = true, nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "user_roles_id")
    )
    private Set<UserRole> roles;


    public User() {

    }

    public User(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.roles = new HashSet<>();
    }

    public User(UserRepr repr) {
        this.id = repr.getId();
        this.name = repr.getName();
        this.password = repr.getPassword();
        this.roles = new HashSet<>();
        repr.getRoles().forEach(userRoleRepr -> this.roles.add(new UserRole(userRoleRepr)));
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }
}
