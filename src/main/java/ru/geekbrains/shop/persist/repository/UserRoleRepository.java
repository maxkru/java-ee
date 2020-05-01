package ru.geekbrains.shop.persist.repository;

import ru.geekbrains.shop.persist.UserRole;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserRoleRepository {

    void insert(UserRole role);

    void remove(int roleId);

    List<UserRole> findAll();

    void update(UserRole role);

    UserRole findById(int roleId);
}
