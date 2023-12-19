<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 12/14/2023
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<form action="/products?action=edit&productID=${selectProduct.getProductID()}" method="post">
    <table>
        <tr>
            <td>productName</td>
            <td>
                <input type="text" name="productName" value="${selectProduct.getProductName()}">
            </td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td>
                <input type="text" name="quantity" value="${selectProduct.getProductQuantity()}">
            </td>
        </tr>
        <tr>
            <td>Price</td>
            <td>
                <input type="text" name="price" value="${selectProduct.getProductCost()}">
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
