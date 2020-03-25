package ru.geekbrains.shop;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter respWriter = resp.getWriter();
        respWriter.print("<h1>Главная страница</h1>");
        req.setAttribute("page", "main");
        req.setAttribute("contextPath", getServletContext().getContextPath());
        getServletContext().getRequestDispatcher("/navbar").include(req, resp);
    }
}
