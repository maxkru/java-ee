package ru.geekbrains.shop.persist.repository;

import ru.geekbrains.shop.persist.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserRepository {

    void insert(User user);

    void remove(int userId);

    List<User> findAll();

    void update(User user);

    User findById(int userId);
}
