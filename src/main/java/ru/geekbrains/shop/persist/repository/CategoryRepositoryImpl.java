package ru.geekbrains.shop.persist.repository;

import ru.geekbrains.shop.persist.Category;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CategoryRepositoryImpl implements CategoryRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @PostConstruct
    public void init() {

    }

    @TransactionAttribute
    public void insert(Category category) {
        em.persist(category);
    }

    @TransactionAttribute
    public void delete(int id) {
        Category category = em.find(Category.class, id);
        if (category != null) {
            em.remove(category);
        }
    }

    public List<Category> findAll() {
        return em.createQuery("FROM Category", Category.class).getResultList();
    }

    @TransactionAttribute
    public void update(Category category) {
        em.merge(category);
    }

    public Category findById(int id) {
        return em.find(Category.class, id);
    }
}