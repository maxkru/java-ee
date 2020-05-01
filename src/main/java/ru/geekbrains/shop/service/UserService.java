package ru.geekbrains.shop.service;

import ru.geekbrains.shop.service.repr.UserRepr;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserService {

    void addUser(UserRepr repr);

    void removeUser(int userId);

    UserRepr findById(int userId);

    void updateUser(UserRepr repr);

    boolean existsById(int userId);

    List<UserRepr> getAllUsers();

}
