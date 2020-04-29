package ru.geekbrains.shop.rest;

import ru.geekbrains.shop.service.repr.ProductRepr;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/v1/product")
public interface ProductServiceRs {

    @PUT
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    void insertProduct(ProductRepr product);

    @DELETE
    @Path("/{id}/id")
    void delete(@PathParam("id") int id);

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    void update(ProductRepr product);

    @GET
    @Path("/{id}/id")
    @Produces(MediaType.APPLICATION_JSON)
    ProductRepr findById(@PathParam("id") int id);

    @GET
    @Path("/{name}/name")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductRepr> findByName(@PathParam("name") String name);

    @GET
    @Path("/{categoryId}/categoryId")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductRepr> findByCategory(@PathParam("categoryId") int categoryId);

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductRepr> findAll();

}
