<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 12/13/2023
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<table border="2">
    <tr>
        <th>Product Name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Edit</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td> <c:out value="${product.getProductName()}" /> </td>
            <td> <c:out value="${product.getProductQuantity()}" /> </td>
            <td> <c:out value="${product.getProductCost()}" /> </td>
            <td><a href="/products?action=displayEditProduct&productID=${product.getProductID()}"> Edit</a></td>
        </tr>
    </c:forEach>
</table>
<h2>
    <a href="/products?action=displayCreateProduct"> Create Product </a>
</h2>
</body>
</html>
