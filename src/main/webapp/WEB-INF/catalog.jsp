<%@ page import="ru.geekbrains.shop.format.DecimalFormatter" %>
<%@ page import="ru.geekbrains.shop.persist.Product" %>
<%@ page import="ru.geekbrains.shop.persist.ProductList" %><%--
  Created by IntelliJ IDEA.
  User: max
  Date: 31.03.2020
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Каталог</title>
</head>
<body>
<h1>Каталог товаров</h1>
<table border="2">
    <tr>
        <th>Наименование</th>
        <th>Цена (руб.)</th>
    </tr>
    <% for (Product product : ((ProductList) application.getAttribute("productList")).getList()) { %>
    <tr>
        <td><a href="<%= request.getContextPath() + "/product?id=" + product.getId() %>"><%= product.getName() %></a></td>
        <td><%= DecimalFormatter.format(product.getPrice()) %></td>
    </tr>
    <% } %>
</table>
<jsp:include page="/navbar">
    <jsp:param name="page" value="catalog"/>
</jsp:include>
</body>
</html>
