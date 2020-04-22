package ru.geekbrains.shop.service.remote;


import ru.geekbrains.shop.persist.Product;
import ru.geekbrains.shop.persist.repository.ProductRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ProductServiceRemoteImpl implements ProductServiceRemote {

    @EJB
    private ProductRepository productRepository;

    @Override
    public List<ProductReprRemote> findAll() {
        return productRepository.findAll().stream()
                .map(this::toRepr)
                .collect(Collectors.toList());
    }

    @Override
    public ProductReprRemote findById(Integer id) {
        Product product = productRepository.findById(id);
        return toRepr(product);
    }

    @Override
    public List<ProductReprRemote> findByCategoryId(Integer categoryId) {
        return productRepository.findByCategory(categoryId).stream()
                .map(this::toRepr)
                .collect(Collectors.toList());
    }

    private ProductReprRemote toRepr(Product product) {
        return new ProductReprRemote(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }


}
