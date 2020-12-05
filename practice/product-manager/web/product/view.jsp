<%--
  Created by IntelliJ IDEA.
  User: pysga1996
  Date: 7/18/19
  Time: 11:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="<%= application.getContextPath() %>/products">Back to product list</a>
</p>
<table>
    <tr>
        <td>Developer: </td>
        <td>${requestScope.product.developer}</td>
    </tr>
    <tr>
        <td>Model: </td>
        <td>${requestScope.product.model}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${requestScope.product.price}</td>
    </tr>
    <tr>
        <td>Description: </td>
        <td>${requestScope.product.description}</td>
    </tr>
</table>
</body>
</html>
