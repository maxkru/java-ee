package ru.geekbrains.shop.persist.repository;

import ru.geekbrains.shop.persist.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Named
@ApplicationScoped
public class ProductRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    private int nextId;

    @PostConstruct
    public void init() {

    }

    @Transactional
    public void insert(Product product) {
        em.persist(product);
    }

    @Transactional
    public void delete(int id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        }
    }

    public List<Product> findAll() {
        return em.createQuery("FROM Product", Product.class).getResultList();
    }

    @Transactional
    public void update(Product product) {
        em.merge(product);
    }

    public Product findById(int id) {
        return em.find(Product.class, id);
    }

    public List<Product> findByCategory(int categoryId) {
        return em.createQuery("FROM Product WHERE Product.category.id = ?", Product.class).setParameter(0, categoryId).getResultList();
    }
}
