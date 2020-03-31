package ru.geekbrains.shop;

import ru.geekbrains.shop.persist.Product;
import ru.geekbrains.shop.persist.ProductList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException | NullPointerException e) {
            resp.sendError(400);
            return;
        }

        Product product = ((ProductList) getServletContext().getAttribute("productList")).findById(id);
        if (product == null) {
            resp.sendError(404);
            return;
        }

        req.setAttribute("product", product);
        getServletContext().getRequestDispatcher("/WEB-INF/product.jsp").forward(req, resp);
    }
}
