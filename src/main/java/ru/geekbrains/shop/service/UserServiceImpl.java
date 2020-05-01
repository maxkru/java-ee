package ru.geekbrains.shop.service;

import ru.geekbrains.shop.persist.User;
import ru.geekbrains.shop.persist.repository.UserRepository;
import ru.geekbrains.shop.service.repr.UserRepr;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class UserServiceImpl implements UserService {

    @EJB
    private UserRepository repository;

    @Override
    public void addUser(UserRepr repr) {
        repository.insert(new User(repr));
    }

    @Override
    public void removeUser(int userId) {
        repository.remove(userId);
    }

    @Override
    public UserRepr findById(int userId) {
        return new UserRepr(repository.findById(userId));
    }

    @Override
    public void updateUser(UserRepr repr) {
        User user = new User(repr);
        repository.update(user);
    }

    @Override
    public boolean existsById(int userId) {
        return findById(userId) != null;
    }

    @Override
    public List<UserRepr> getAllUsers() {
        return repository.findAll().stream()
                .map(UserRepr::new)
                .collect(Collectors.toList());
    }
}
