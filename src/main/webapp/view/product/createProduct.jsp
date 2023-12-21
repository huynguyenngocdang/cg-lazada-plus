<<<<<<< HEAD
<%@ page import="com.codegym.cglazadaplusproject.model.User" %><%--
  Created by IntelliJ IDEA.
  User: long
  Date: 12/13/2023
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
=======
<%@ page import="com.codegym.cglazadaplusproject.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
>>>>>>> fa19d4173861fdf1e572a7d390199cb25e7eb65a
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
<<<<<<< HEAD
<center>
    <h1>New Product</h1>
</center>
<div align="center">
    <<form action="/products?action=createProduct" method="post">
        <table>
<%--            <tr>--%>
<%--                <th>User ID:</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="userID" id="userID" size="45"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr>
                <th>Product Name:</th>
                <td>
                    <input type="text" name="productName" id="productName" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td>
                    <input type="text" name="quantity" id="quantity" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="price" id="price" size="45"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<script src="../../js/animation.js"></script>
</body>
</html>