package ru.geekbrains.shop.service;

import ru.geekbrains.shop.persist.Category;
import ru.geekbrains.shop.persist.repository.CategoryRepository;

import javax.ejb.EJB;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @EJB
    private CategoryRepository repository;

    @Override
    public void insert(Category category) {
        repository.insert(category);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(Category category) {
        repository.update(category);
    }

    @Override
    public Category findById(int id) {
        return repository.findById(id);
    }
}
