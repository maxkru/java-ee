package ru.geekbrains.shop;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.LinkedHashMap;

@WebServlet(name = "NavigationBarServlet", urlPatterns = {"/navbar"})
public class NavigationBarServlet implements Servlet {
    private static LinkedHashMap<String, String> pages;

    static {
        pages = new LinkedHashMap<>();
        pages.put("main", "Главная страница");
        pages.put("cart", "Корзина");
        pages.put("order", "Оформление заказа");
        pages.put("product", "Описание товара");
        pages.put("catalog", "Каталог");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        for (String page : pages.keySet()) {
            if (req.getAttribute("page").equals(page)) {
                resp.getWriter().print(pages.get(page) + " ");
            } else {
                resp.getWriter().printf("<a href=%s/%s>%s</a> ", req.getAttribute("contextPath"), page, pages.get(page));
            }
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
