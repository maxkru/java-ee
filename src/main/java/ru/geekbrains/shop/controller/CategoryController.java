package ru.geekbrains.shop.controller;

import ru.geekbrains.shop.service.CategoryService;
import ru.geekbrains.shop.service.repr.CategoryRepr;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CategoryController implements Serializable {
    @EJB
    private CategoryService service;

    private CategoryRepr categoryRepr;

    public CategoryRepr getCategoryRepr() {
        return categoryRepr;
    }

    public void setCategoryRepr(CategoryRepr categoryRepr) {
        this.categoryRepr = categoryRepr;
    }

    public String createcategoryRepr() {
        this.categoryRepr = new CategoryRepr();
        return "category.xhtml?faces-redirect=true";
    }

    public List<CategoryRepr> getAllCategories() {
        return service.findAll();
    }

    public String editCategory(CategoryRepr categoryRepr) {
        this.categoryRepr = categoryRepr;
        return "category.xhtml?faces-redirect=true";
    }

    public void deleteCategoryRepr(CategoryRepr categoryRepr) {
        service.delete(categoryRepr.getId());
    }

    public String saveCategoryRepr() {
        if (categoryRepr.getId() == null)
            service.insertCategory(categoryRepr);
        else
            service.update(categoryRepr);
        return "control_panel.xhtml?faces-redirect=true";
    }
}