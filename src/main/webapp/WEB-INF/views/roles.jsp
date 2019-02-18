<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Roles</title>
    <%@ page isELIgnored="false" %>
</head>
<body>

    <br>
    <br>
    <table border="1" align="center">

        <th>Role Name</th>
        <th>Description</th>

        <c:forEach var="role" items="${listRoles}">
            <tr>
                <td>${role.name}</td>
                <td>${role.description}</td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <br>
    <br>

    <form:form id="roleForm" modelAttribute="role" action="addroles" method="post">
        <table align="center">
            <tr>
                <td>
                    <form:label path="name">name: </form:label>
                </td>
                <td>
                    <form:input path="name" name="name" id="name" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="description">description: </form:label>
                </td>
                <td>
                    <form:input path="description" name="description" id="description" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td align="left">
                    <form:button id="new" name="role">Add new</form:button>
                </td>
            </tr>
            <tr></tr>
            <tr>
                <td></td>
                <td><a href="/">Home</a>
                </td>
            </tr>
        </table>
    </form:form>

</body>
</html>