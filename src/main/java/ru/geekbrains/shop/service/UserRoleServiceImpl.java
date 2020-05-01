package ru.geekbrains.shop.service;

import ru.geekbrains.shop.persist.repository.UserRoleRepository;
import ru.geekbrains.shop.service.repr.UserRoleRepr;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class UserRoleServiceImpl implements UserRoleService {

    @EJB
    UserRoleRepository repository;

    @Override
    public List<UserRoleRepr> getAllRoles() {
        return repository.findAll().stream()
                .map(UserRoleRepr::new)
                .collect(Collectors.toList());
    }
}
