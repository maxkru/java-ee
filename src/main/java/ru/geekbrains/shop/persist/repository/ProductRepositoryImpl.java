package ru.geekbrains.shop.persist.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.shop.persist.Product;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ProductRepositoryImpl implements ProductRepository {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepositoryImpl.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @PostConstruct
    public void init() {

    }

    @Override
    @TransactionAttribute
    public void insert(Product product) {
        logger.info("insert");
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
        logger.info("update");
        em.merge(product);
    }

    @Override
    public Product findById(int id) {
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> findByName(String name) {
        TypedQuery<Product> q = em.createQuery("SELECT p FROM Product p WHERE p.name = :name", Product.class);
        q.setParameter("name", name);
        return q.getResultList();
    }

    @Override
    public List<Product> findByCategory(int categoryId) {
        logger.info("findByCategory");
        TypedQuery<Product> q = em.createQuery("SELECT p FROM Product p WHERE p.category.id = :categoryId", Product.class);
        q.setParameter("categoryId", categoryId);
        return q.getResultList();
    }
}
