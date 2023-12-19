<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/13/2023
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/users?action=edit&userId=${selectUser.getUserId()}" method="post">

    <table>
        <tr>
            <td>Name</td>
            <td>
                <input type="text" name="newUsername" value="${selectUser.getUsername()}">
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td>
                <input type="text" name="newUserPassword" value="${selectUser.getUserPassword()}">
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
