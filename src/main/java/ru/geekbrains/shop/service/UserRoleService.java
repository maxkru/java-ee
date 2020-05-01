package ru.geekbrains.shop.service;

import ru.geekbrains.shop.service.repr.UserRoleRepr;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserRoleService {

    List<UserRoleRepr> getAllRoles();

}
