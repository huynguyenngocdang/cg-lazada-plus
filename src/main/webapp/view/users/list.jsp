<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/13/2023
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List all user</title>
</head>
<body>
    <table>
        <tr>
            <th>Username</th>
            <th>UserPassword</th>
            <th></th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td> <c:out value="${user.getUsername()}" /> </td>
                <td> <c:out value="${user.getUserPassword()}" /> </td>
                <td><a href="${pageContext.request.contextPath}/users?action=showEdit&userId=${user.getUserId()}"> Edit </a> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
