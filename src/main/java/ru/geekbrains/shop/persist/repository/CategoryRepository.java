package ru.geekbrains.shop.persist.repository;

import ru.geekbrains.shop.persist.Category;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CategoryRepository {

    void insert(Category category);

    void delete(int id);

    List<Category> findAll();

    void update(Category category);

    Category findById(int id);
}