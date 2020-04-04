<%--
  Created by IntelliJ IDEA.
  User: max
  Date: 31.03.2020
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>
</head>
<body>
<h1>Главная страница</h1>
<jsp:include page="/navbar">
    <jsp:param name="page" value="main"/>
</jsp:include>
</body>
</html>
