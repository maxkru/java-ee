package ru.geekbrains.shop.persist;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Connection;

@Named
@ApplicationScoped
public class ProductRepository {

    private Connection connection;
    private DataSource dataSource;

    @Inject
    public ProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void init() {
        connection = dataSource.getConnection();
    }

    public void insert(Product product) {
        // TODO
    }

    // TODO
}
