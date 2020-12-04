<%--
  Created by IntelliJ IDEA.
  User: pysga1996
  Date: 7/18/19
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h2>Simple Calculator</h2>
  <form action="<%= application.getContextPath() %>/calculator" method="post">
    <span>Calculator</span>
    <label for="first_operand">First Operand</label><input type="number" id="first_operand" name="first_operand">
    <label for="operator"></label><select id="operator" name="operator">
      <option value="+">Addition</option>
      <option value="-">Subtraction</option>
      <option value="*">Multiplication</option>
      <option value="/">Division</option>
    </select>
    <label for="second_operand">Second Operand</label><input type="number" id="second_operand" name="second_operand">
    <input type="submit" value="Calculate"/>
  </form>
  </body>
</html>
