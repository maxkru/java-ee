package ru.geekbrains.shop.controller;


import ru.geekbrains.shop.service.UserRoleService;
import ru.geekbrains.shop.service.UserService;
import ru.geekbrains.shop.service.repr.UserRepr;
import ru.geekbrains.shop.service.repr.UserRoleRepr;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class UserController implements Serializable {

    @EJB
    private UserService userService;

    @EJB
    private UserRoleService roleService;

    private UserRepr userRepr;

    private List<UserRepr> users;
    private List<UserRoleRepr> roles;

    public void preLoad() {
        this.users = userService.getAllUsers();
        this.roles = roleService.getAllRoles();
    }

    public UserRepr getUserRepr() {
        return userRepr;
    }

    public void setUserRepr(UserRepr userRepr) {
        this.userRepr = userRepr;
    }

    public List<UserRepr> getAllUsers() {
        return users;
    }

    public List<UserRoleRepr> getAllRoles() {
        return roles;
    }

    public List<UserRoleRepr> getUserRoles() {
        return new ArrayList<>();
    }

    public String createUser() {
        userRepr = new UserRepr();
        return "/admin/user.xhtml?faces-redirect=true";
    }

    public String saveUser() {
        userService.updateUser(userRepr);
        return "/admin/users.xhtml?faces-redirect=true";
    }

    public String editUser(UserRepr userRepr) {
        this.userRepr = userRepr;
        return "/admin/user.xhtml?faces-redirect=true";
    }

    public void deleteUser(UserRepr userRepr) {
        userService.removeUser(userRepr.getId());
    }
}
