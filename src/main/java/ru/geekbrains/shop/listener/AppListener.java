package ru.geekbrains.shop.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.shop.persist.Product;
import ru.geekbrains.shop.persist.ProductList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;
import java.util.List;

@WebListener
public class AppListener implements ServletContextListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductList productList = new ProductList();
        sce.getServletContext().setAttribute("productList", productList);
        List<Product> list = productList.getList();
        list.add(new Product(1, "Гречка", "Пачка гречневой крупы, 1 кг", new BigDecimal(60)));
        list.add(new Product(2, "Туалетная бумага", "Рулон туалетной бумаги", new BigDecimal(15)));
        list.add(new Product(3, "Сгущёнка", "Банка сгущённого молока", new BigDecimal(65)));
        list.add(new Product(4, "Тушёнка", "Банка тушёной говядины", new BigDecimal(70)));
        list.add(new Product(5, "Спички", "Коробок спичек", new BigDecimal(4)));
        list.add(new Product(6, "Медицинская маска", "Медицинская маска для лица", new BigDecimal(10)));
        list.add(new Product(7, "Овсяная крупа", "Пачка овсяной крупы, 1 кг", new BigDecimal(50)));
        list.add(new Product(8, "Молоко", "Упаковка ультрапастеризованного молока, 1 л", new BigDecimal(64)));
        list.add(new Product(9, "Масло подсолнечное", "Бутылка рафинированного подсолнечного масла, 1 л", new BigDecimal(70)));
    }
}
