<%--
  Created by IntelliJ IDEA.
  User: pysga1996
  Date: 7/19/19
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Products</h1>
<p>
    <a href="<%= application.getContextPath() %>/products">Back to product list</a><br>
    <c:if test='${requestScope.message != null}'>
        <span class="message">${requestScope.message}</span>
    </c:if>
</p>
<form method="get">
    <input type="text" name="name" value="${requestScope.name}" placeholder="Type a product name to search">
    <input type="submit" name="action" value="Search">
</form>
<table style="border: 1px">
    <tr>
        <td>Developer</td>
        <td>Model</td>
        <td>Price</td>
        <td>Description</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope.filterProducts}' var="product">
        <tr>
            <td><a href="products/view/${product.id}">${product.developer}</a></td>
            <td>${product.model}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td><a href="products/edit/${product.id}">Edit</a></td>
            <td><a href="products/delete/${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
