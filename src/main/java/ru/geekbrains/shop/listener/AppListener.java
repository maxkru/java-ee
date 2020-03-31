package ru.geekbrains.shop.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.shop.persist.Product;
import ru.geekbrains.shop.persist.ProductList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class AppListener implements ServletContextListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductList productList = new ProductList();
        sce.getServletContext().setAttribute("productList", productList);
        productList.getList().add(new Product(1, "Гречка", "Пачка гречневой крупы", new BigDecimal(60)));
    }
}
