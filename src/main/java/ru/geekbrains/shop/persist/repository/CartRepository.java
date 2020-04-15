package ru.geekbrains.shop.persist.repository;

import ru.geekbrains.shop.persist.Cart;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Named
@ApplicationScoped
public class CartRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @PostConstruct
    public void init() {

    }

    @Transactional
    public void insert(Cart cart) {
        em.persist(cart);
    }

    @Transactional
    public void delete(int id) {
        Cart cart = em.find(Cart.class, id);
        if (cart != null) {
            em.remove(cart);
        }
    }

    public List<Cart> findAll() {
        return em.createQuery("FROM Cart", Cart.class).getResultList();
    }

    @Transactional
    public void update(Cart cart) {
        em.merge(cart);
    }

    public Cart findById(int id) {
        return em.find(Cart.class, id);
    }
}
