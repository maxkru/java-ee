package ru.geekbrains.shop.service;

import ru.geekbrains.shop.persist.repository.ProductRepository;
import ru.geekbrains.shop.persist.repository.ProductRepr;
import ru.geekbrains.shop.persist.repository.ProductServiceRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ProductServiceRemoteImpl implements ProductServiceRemote {

    @EJB
    private ProductRepository productRepository;

    @Override
    public List<ProductRepr> findAll() {
        return productRepository.findAll().stream()
                .map(p -> new ProductRepr(p.getId(), p.getName(), p.getDescription(), p.getPrice()))
                .collect(Collectors.toList());
    }
}
