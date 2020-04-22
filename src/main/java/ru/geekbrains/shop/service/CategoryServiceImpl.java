package ru.geekbrains.shop.service;

import ru.geekbrains.shop.persist.Category;
import ru.geekbrains.shop.persist.repository.CategoryRepository;
import ru.geekbrains.shop.service.repr.CategoryRepr;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CategoryServiceImpl implements CategoryService {

    @EJB
    private CategoryRepository repository;

    @Override
    public void insert(CategoryRepr repr) {
        repository.insert(new Category(
                repr.getId(),
                repr.getName(),
                repr.getDescription()
        ));
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public List<CategoryRepr> findAll() {
        return repository.findAll().stream()
                .map(category -> new CategoryRepr(
                        category.getId(),
                        category.getName(),
                        category.getDescription()
                )).collect(Collectors.toList());
    }

    @Override
    public void update(CategoryRepr repr) {
        repository.update(new Category(
                repr.getId(),
                repr.getName(),
                repr.getDescription()
        ));
    }

    @Override
    public CategoryRepr findById(int id) {
        Category category = repository.findById(id);
        return category == null ? null : new CategoryRepr(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }
}
