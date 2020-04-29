package ru.geekbrains.shop.rest;

import ru.geekbrains.shop.service.repr.CategoryRepr;

import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Local
@Path("/v1/category")
public interface CategoryServiceRs {

    @PUT
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    void insertCategory(CategoryRepr product);

}
