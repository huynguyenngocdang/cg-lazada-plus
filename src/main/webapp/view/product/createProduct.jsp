<%@ page import="com.codegym.cglazadaplusproject.model.User" %><%--
  Created by IntelliJ IDEA.
  User: long
  Date: 12/13/2023
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Thông tin sản phẩm</title>
    <script src="https://kit.fontawesome.com/94d7aff8f4.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto" rel="stylesheet">
    <link rel="shortcut icon" href="../../images/titleIcon.png">
    <link rel="stylesheet" type="text/css" href="../../css/base.css">
    <link rel="stylesheet" type="text/css" href="../../css/user.css">
</head>
<body>

<center>
    <h1>New Product</h1>
</center>
<div align="center">
    <form action="/products?action=createProduct" method="post">
        <table>
            <tr>
                <td>Product Name:</td>
                <td>
                    <input type="text" name="productName" id="productName" size="45"/>
                </td>
            </tr>
            <tr>
                <td>Quantity:</td>
                <td>
                    <input type="number" name="quantity" id="quantity" min="0"  size="45"/>
                </td>
            </tr>
            <tr>
                <td>Price:</td>
                <td>
                    <input type="number" name="price" id="price" min="0"  size="45"/>
                </td>
            </tr>
            <tr>
                <td>Category:</td>
                <td>
                    <select name="category" id="category">
                        <c:forEach var="category" items="${categories}">
                            <option value="${category.categoryId}">${category.categoryName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit"> SaveProduct</button>
                </td>
            </tr>

        </table>
    </form>
</div>
<script src="../../js/animation.js"></script>
</body>
</html>