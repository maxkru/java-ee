package ru.geekbrains.shop;

import ru.geekbrains.shop.service.CategoryService;
import ru.geekbrains.shop.service.CategoryServiceWs;
import ru.geekbrains.shop.service.ProductService;
import ru.geekbrains.shop.service.ProductServiceWs;
import ru.geekbrains.shop.service.ws.CategoryRepr;
import ru.geekbrains.shop.service.ws.ProductRepr;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

public class WsClient {

    public static void main(String[] args) throws MalformedURLException {
        URL productWsUrl = new URL("http://localhost:8080/java-ee/ProductService/ProductServiceImpl?wsdl");
        URL categoryWsUrl = new URL("http://localhost:8080/java-ee/CategoryService/CategoryServiceImpl?wsdl");

        ProductService productService = new ProductService(productWsUrl);
        ProductServiceWs productServicePort = productService.getProductServiceImplPort();

        ProductRepr productRepr = new ProductRepr();
        productRepr.setName("Ws");
        productRepr.setDescription("Ws-inserted");
        productRepr.setCategoryId(1);
        productRepr.setPrice(new BigDecimal("123.12"));

        productServicePort.insertProduct(productRepr);

        System.out.println("Products:\n");
        productServicePort.findAll().forEach(WsClient::printProductInfo);

        CategoryService categoryService = new CategoryService(categoryWsUrl);
        CategoryServiceWs categoryServicePort = categoryService.getCategoryServiceImplPort();

        CategoryRepr categoryRepr = new CategoryRepr();
        categoryRepr.setName("Ws");
        categoryRepr.setDescription("Ws-inserted");
        categoryServicePort.insertCategory(categoryRepr);

    }

    private static void printProductInfo(ProductRepr productRepr) {
        System.out.println("ID = " + productRepr.getId());
        System.out.println("Name = " + productRepr.getName());
        System.out.println("Description = " + productRepr.getDescription());
        System.out.println("Price = " + productRepr.getPrice());
        System.out.println("Category ID = " + productRepr.getCategoryId());
        System.out.println();
    }


}
