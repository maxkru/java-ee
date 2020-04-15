package ru.geekbrains.shop.persist.repository;

import ru.geekbrains.shop.persist.Category;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Named
@ApplicationScoped
public class CategoryRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @PostConstruct
    public void init() {

    }

    @Transactional
    public void insert(Category category) {
        em.persist(category);
    }

    @Transactional
    public void delete(int id) {
        Category category = em.find(Category.class, id);
        if (category != null) {
            em.remove(category);
        }
    }

    public List<Category> findAll() {
        return em.createQuery("FROM Category", Category.class).getResultList();
    }

    @Transactional
    public void update(Category category) {
        em.merge(category);
    }

    public Category findById(int id) {
        return em.find(Category.class, id);
    }
}