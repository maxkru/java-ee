package ru.geekbrains.shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter respWriter = resp.getWriter();
        respWriter.print("<h1>Корзина</h1>");
        respWriter.printf("<a href=%1$s/main>Главная страница</a> " +
                "Корзина " +
                "<a href=%1$s/order>Оформление заказа</a> " +
                "<a href=%1$s/product>Описание товара</a> " +
                "<a href=%1$s/catalog>Каталог</a>", getServletContext().getContextPath());
    }
}
