<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
    <%@ page isELIgnored="false" %>
</head>
<body>

    <br>
    <br>
    <br>
    <table border="1" align="center">

        <th>User Name</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>

        <c:forEach var="user" items="${listUsers}">
            <tr>
                <td>${user.username}</td>
                <td>${user.firstname}</td>
                <td>${user.lastname}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>${user.address}</td>
                <td><td><form action="/user/delete.html?selectedUser=${user.username}"  method="post"><input type="submit" value="Delete"/></form></td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <br>
    <br>
    <br>

    <table align="center">
        <tr>
            <td><a href="login">Login</a></td>
            <td><a href="register">Register</a></td>
            <td><a href="roles">Roles</a></td>
        </tr>
    </table>

</body>
</html>