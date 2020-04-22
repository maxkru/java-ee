package ru.geekbrains.shop.service;

import ru.geekbrains.shop.persist.Category;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CategoryService {
    void insert(Category category);

    void delete(int id);

    List<Category> findAll();

    void update(Category category);

    Category findById(int id);
}
