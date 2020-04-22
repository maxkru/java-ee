package ru.geekbrains.shop.service;

import ru.geekbrains.shop.service.repr.CategoryRepr;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CategoryService {
    void insert(CategoryRepr categoryRepr);

    void delete(int id);

    List<CategoryRepr> findAll();

    void update(CategoryRepr categoryRepr);

    CategoryRepr findById(int id);
}
