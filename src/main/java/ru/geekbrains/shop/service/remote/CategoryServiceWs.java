package ru.geekbrains.shop.service.remote;

import ru.geekbrains.shop.service.repr.CategoryRepr;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CategoryServiceWs {

    @WebMethod
    void insert(CategoryRepr categoryRepr);

}
