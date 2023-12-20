<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 12/14/2023
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>

<c:if test='${requestScope["message"] != null}'>
    <span class="message" style="font-size: 20px">${requestScope["message"]} </span>
</c:if>

<form action="/products?action=editProduct&productID=${selectProduct.productId}" method="post">
    <table>
        <tr>
            <td>Product Name</td>
            <td>
                <input type="text" name="productName" value="${selectProduct.productName}">
            </td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td>
                <input type="text" name="quantity" value="${selectProduct.productQuantity}">
            </td>
        </tr>
        <tr>
            <td>Price</td>
            <td>
                <input type="text" name="price" value="${selectProduct.productCost}">
            </td>
        </tr>
        <tr>
            <td><button type="submit">Edit</button></td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>
