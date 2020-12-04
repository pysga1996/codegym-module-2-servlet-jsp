<%--
  Created by IntelliJ IDEA.
  User: pysga1996
  Date: 7/17/19
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Product Discount Calculator</title>
</head>
<body>
<form action="<%= application.getContextPath() %>/result" method="post">
  <h2>Product Discount Calculator</h2>
  <label for="product_description">Product Description</label>
  <input type="text" id="product_description" name="product_description"><br>
  <label for="list_price">List Price</label>
  <input type="number" step="0.01" id="list_price" name="list_price"><br>
  <label for="discount_percent">Discount Percent (%)</label>
  <input type="number" step="0.01" id="discount_percent" name="discount_percent"><br>
  <input type="submit" id="calculate_discount" name="calculate_discount" value="Calculate Discount"><br>
</form>
</body>
</html>
