<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 12/13/2023
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<center>
    <h1>New Product</h1>
</center>
<div align="center">
    <form action="/products?action=createProduct" method="post">
        <table>

            <tr>
                <th>User ID:</th>
                <td>
                    <input type="text" name="userID" id="userID" size="45"/>
                </td>
            </tr>
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

            <tr>
                <td colspan="2" align="center">
                    <button type="submit"> SaveProduct</button>
                </td>
            </tr>

        </table>
    </form>
</div>
</body>
</html>
