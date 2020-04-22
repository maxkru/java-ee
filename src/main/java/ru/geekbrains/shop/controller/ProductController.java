package ru.geekbrains.shop.controller;

import ru.geekbrains.shop.persist.Product;
import ru.geekbrains.shop.service.ProductService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProductController implements Serializable {

    @EJB
    private ProductService productService;

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String createProduct() {
        this.product = new Product();
        return "product.xhtml?faces-redirect=true";
    }

    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    public String editProduct(Product product) {
        this.product = product;
        return "product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(Product product) {
        productService.delete(product.getId());
    }

    public String saveProduct() {
        if (product.getId() == null)
            productService.insert(product);
        else
            productService.update(product);
        return "control_panel.xhtml?faces-redirect=true";
    }
}
