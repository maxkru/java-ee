package ru.geekbrains.shop.persist.repository;

import ru.geekbrains.shop.persist.User;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Override
    @TransactionAttribute
    public void insert(User user) {
        em.persist(user);
    }

    @Override
    @TransactionAttribute
    public void remove(int userId) {
        User user = em.find(User.class, userId);
        if (user != null) {
            em.remove(user);
        }
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    @TransactionAttribute
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public User findById(int userId) {
        return em.find(User.class, userId);
    }
}
