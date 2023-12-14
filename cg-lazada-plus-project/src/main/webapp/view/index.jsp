<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lazada Plus Project</title>
</head>
<body>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]} </span>
    </c:if>
</p>

<br/>

<form action="/users?action=login" method="post">
    <fieldset>
        <legend>Login information</legend>
        <table>
            <tr>
                <td>Username</td>
                <td>
                    <input type="text" name="username" id="username" placeholder="Input your username">
                </td>
            </tr>
            <tr>
                <td>Password</td>
                <td>
                    <input type="password" name="password" id="password">
                </td>
            </tr>
            <tr>
                <td><button type="submit">Login</button> </td>
                <td></td>
            </tr>
        </table>
    </fieldset>
</form>

<a href="/users">List all user</a>
</body>
</html>