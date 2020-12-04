<%@ page import="java.util.ArrayList" %>
<%@ page import="customers.Customer" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.GregorianCalendar" %>
<%--
  Created by IntelliJ IDEA.
  User: pysga1996
  Date: 7/18/19
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Customers List</title>
  </head>
  <body>
  <%
    ArrayList<Customer> customersList = new ArrayList<>();
    customersList.add(new Customer("Mai Văn Hoàn",new GregorianCalendar(1983,7,20),"Hà Nội","mai_van_hoan.png"));
    customersList.add(new Customer("Nguyễn Văn Nam",new GregorianCalendar(1983,7,21),"Bắc Giang","nguyen_van_nam.png"));
    customersList.add(new Customer("Nguyễn Thái Hòa",new GregorianCalendar(1983,7,22),"Nam Định","nguyen_thai_hoa.png"));
    customersList.add(new Customer("Trần Đăng Khoa",new GregorianCalendar(1983,7,17),"Hà Tây","tran_dang_khoa.png"));
    customersList.add(new Customer("Nguyễn Đình Thi",new GregorianCalendar(1983,7,19),"Hà Nội","nguyen_dinh_thi.png"));
    pageContext.setAttribute("customersList",customersList);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    pageContext.setAttribute("sdf",sdf);

  %>
  <table>
    <tr>
      <th>Name</th>
      <th>Date of Birth</th>
      <th>Address</th>
      <th>Image</th>
    </tr>
    <c:forEach items="${customersList}" var="customer">
      <tr>
        <td><c:out value="${customer.getName()}"/> </td>
        <td><c:out value="${sdf.format(customer.getDate_of_birth().getTime())}"/></td>
        <td><c:out value="${customer.getAddress()}"/></td>
        <td><img src="images/<c:out value="${customer.getImage()}"/>" height="91" width="91"/></td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
