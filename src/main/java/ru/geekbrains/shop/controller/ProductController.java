package ru.geekbrains.shop.controller;

import ru.geekbrains.shop.service.ProductService;
import ru.geekbrains.shop.service.repr.ProductRepr;

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

    private ProductRepr productRepr;

    public ProductRepr getProductRepr() {
        return productRepr;
    }

    public void setProductRepr(ProductRepr productRepr) {
        this.productRepr = productRepr;
    }

    public String createProduct() {
        this.productRepr = new ProductRepr();
        return "product.xhtml?faces-redirect=true";
    }

    public List<ProductRepr> getAllProducts() {
        return productService.findAll();
    }

    public String editProduct(ProductRepr productRepr) {
        this.productRepr = productRepr;
        return "product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(ProductRepr productRepr) {
        productService.delete(productRepr.getId());
    }

    public String saveProduct() {
        if (productRepr.getId() == null)
            productService.insert(productRepr);
        else
            productService.update(productRepr);
        return "control_panel.xhtml?faces-redirect=true";
    }
}
