<%@ page import="ru.geekbrains.shop.format.DecimalFormatter" %>
<%@ page import="ru.geekbrains.shop.persist.Product" %><%--
  Created by IntelliJ IDEA.
  User: max
  Date: 31.03.2020
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% Product product = (Product) request.getAttribute("product"); %>
<html>
<head>
    <title><%= product.getName() %> - описание товара</title>
</head>
<body>
<h1><%= product.getName() %></h1>
<p><%= product.getDescription() %></p>
<p>Цена: <%= DecimalFormatter.format(product.getPrice()) %> рублей</p>
</body>
</html>
