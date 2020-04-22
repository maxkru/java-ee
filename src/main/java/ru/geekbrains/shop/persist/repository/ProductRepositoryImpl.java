package ru.geekbrains.shop.persist.repository;

import ru.geekbrains.shop.persist.Product;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    private int nextId;

    @PostConstruct
    public void init() {

    }

    @Override
    @TransactionAttribute
    public void insert(Product product) {
        em.persist(product);
    }

    @Override
    @TransactionAttribute
    public void delete(int id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        }
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("FROM Product", Product.class).getResultList();
    }

    @Override
    @TransactionAttribute
    public void update(Product product) {
        em.merge(product);
    }

    @Override
    public Product findById(int id) {
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> findByCategory(int categoryId) {
        return em.createQuery("FROM Product WHERE Product.category.id = ?", Product.class).setParameter(0, categoryId).getResultList();
    }
}
