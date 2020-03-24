package ru.geekbrains.shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter respWriter = resp.getWriter();
        respWriter.print("<h1>Описание товара</h1>");
        respWriter.printf("<a href=%1$s/main>Главная страница</a> " +
                "<a href=%1$s/cart>Корзина</a> " +
                "<a href=%1$s/order>Оформление заказа</a> " +
                "Описание товара " +
                "<a href=%1$s/catalog>Каталог</a>", getServletContext().getContextPath());
    }
}
