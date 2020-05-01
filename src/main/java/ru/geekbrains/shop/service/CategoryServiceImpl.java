package ru.geekbrains.shop.service;

import ru.geekbrains.shop.persist.Category;
import ru.geekbrains.shop.persist.repository.CategoryRepository;
import ru.geekbrains.shop.rest.CategoryServiceRs;
import ru.geekbrains.shop.service.repr.CategoryRepr;
import ru.geekbrains.shop.service.ws.CategoryServiceWs;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@WebService(endpointInterface = "ru.geekbrains.shop.service.ws.CategoryServiceWs", serviceName = "CategoryService")
public class CategoryServiceImpl implements CategoryService, CategoryServiceWs, CategoryServiceRs {

    @EJB
    private CategoryRepository repository;

    @PostConstruct
    public void init() {
        if (repository.findAll().isEmpty())
            repository.insert(new Category(1, "Category 1", "First category"));
    }

    @Override
    public void insertCategory(CategoryRepr repr) {
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
