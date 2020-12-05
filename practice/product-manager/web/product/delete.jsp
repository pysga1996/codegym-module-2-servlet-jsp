<%--
  Created by IntelliJ IDEA.
  User: pysga1996
  Date: 7/18/19
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="<%= application.getContextPath() %>/products">Back to product list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
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
            <tr>
                <td><input type="submit" value="Delete product"></td>
                <td><a href="<%= application.getContextPath() %>/products">Back to product list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
