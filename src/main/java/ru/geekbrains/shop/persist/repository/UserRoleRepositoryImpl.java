package ru.geekbrains.shop.persist.repository;

import ru.geekbrains.shop.persist.UserRole;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserRoleRepositoryImpl implements UserRoleRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Override
    @TransactionAttribute
    public void insert(UserRole role) {
        em.persist(role);
    }

    @Override
    @TransactionAttribute
    public void remove(int roleId) {
        UserRole role = em.find(UserRole.class, roleId);
        if (role != null)
            em.remove(role);
    }

    @Override
    public List<UserRole> findAll() {
        return em.createQuery("SELECT role FROM UserRole role", UserRole.class).getResultList();
    }

    @Override
    @TransactionAttribute
    public void update(UserRole role) {
        em.merge(role);
    }

    @Override
    public UserRole findById(int roleId) {
        return em.find(UserRole.class, roleId);
    }
}
