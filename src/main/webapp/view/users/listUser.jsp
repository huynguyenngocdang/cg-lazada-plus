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
            <td><c:out value="${user.getUsername()}"/></td>
            <td><c:out value="${user.getUserPassword()}"/></td>
            <td><a href="<c:url value="/users?action=showEdit&userId=${user.getUserId()}"/>"> Edit </a></td>
        </tr>
    </c:forEach>
</table>
<script src="../../js/animation.js"></script>
<script>
    let accountOverlayButton = document.getElementById("AccountOverlayButton");
    let accountOverlay = document.getElementById("AccountOverlay");
    function displayAccountOverlay() {
        accountOverlay.style.opacity = "1";
        accountOverlay.style.visibility = "visible";
        accountOverlay.style.display = "flex";
    }

    function inDisplayAccountOverlay() {
        accountOverlay.style.opacity = "0";
        // accountOverlay.style.visibility = "hidden";
        accountOverlay.style.display = "none";
    }

    function inDisplayAccountOverlay2() {
        accountOverlay.style.opacity = "0";
        accountOverlay.style.visibility = "hidden";
        // accountOverlay.style.display = "none";
    }

    function displayOrangeAccountButton() {
        accountOverlayButton.style.color = "#f25c05";
    }

    function inDisplayOrangeAccountButton() {
        accountOverlayButton.style.color = "#9d9d9d";
    }
    accountOverlayButton.addEventListener("mouseover", displayAccountOverlay);
    accountOverlayButton.addEventListener("mouseout", inDisplayAccountOverlay2);
    accountOverlay.addEventListener("mouseover", displayAccountOverlay, displayOrangeAccountButton);
    accountOverlay.addEventListener("mouseout", inDisplayAccountOverlay, inDisplayOrangeAccountButton);
</script>
</body>
</html>