package ru.geekbrains.shop.persist;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class CategoryRepository {

    private List<Category> categories;

    private int nextId;

    @PostConstruct
    public void init() {
        categories = new ArrayList<>();
        categories.add(new Category(1, "Раз", "РАЗРАЗ"));
        categories.add(new Category(2, "Два", "ДВАДВА"));

        nextId = categories.size() + 1;
    }

    public void insert(Category category) {
        category.setId(nextId++);
        categories.add(category);
    }

    public void delete(int id) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId() == id) {
                categories.remove(i);
                break;
            }
        }
    }

    public List<Category> findAll() {
        return categories;
    }

    public void update(Category category) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId() == category.getId()) {
                categories.remove(i);
                categories.add(i, category);
                break;
            }
        }
    }

    public Category findById(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }
}