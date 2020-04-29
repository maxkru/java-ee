package ru.geekbrains.shop.service.remote;

import ru.geekbrains.shop.service.repr.ProductRepr;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProductServiceWs {

    @WebMethod
    void insert(ProductRepr productRepr);

    @WebMethod
    void delete(int id);

    @WebMethod
    ProductRepr findById(int id);

    @WebMethod
    List<ProductRepr> findAll();

    @WebMethod
    List<ProductRepr> findByName(String name);

    @WebMethod
    List<ProductRepr> findByCategory(int id);

}
