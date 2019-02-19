<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User Management</title>
    <style>
        .error
        {
            color: #ff0000;
            font-weight: bold;
        }
        #listOfEmployees tr:first-child{
            font-weight: bold;
        }
    </style>
</head>

<body>

<%--<h2><spring:message code="lbl.page.list" text="lbl.page.list" /></h2>--%>
<br/>

<table id="listOfEmployees" border="1">
    <tr>
        <td>ID</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Email</td>
        <td>Role</td>
    </tr>
    <c:forEach items="${allUsers}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstname}</td>
            <td>${user.lastname}</td>
            <td>${user.email}</td>
            <td>${user.role.name}</td>
        </tr>
    </c:forEach>
</table>

<h2><spring:message code="lbl.page" text="Add New User" /></h2>
<br/>
<form:form method="post" modelAttribute="user">
    <table>
        <tr>
            <td><spring:message code="lbl.firstname" text="First Name" /></td>
            <td><form:input path="firstname" /></td>
            <td><form:errors path="firstname" cssClass="error" /></td>
        </tr>
        <tr>
            <td><spring:message code="lbl.lastname" text="Last Name" /></td>
            <td><form:input path="lastname" /></td>
            <td><form:errors path="lastname" cssClass="error" /></td>
        </tr>
        <tr>
            <td><spring:message code="lbl.email" text="Email Id" /></td>
            <td><form:input path="email" /></td>
            <td><form:errors path="email" cssClass="error" /></td>
        </tr>
        <tr>
            <td><spring:message code="lbl.role" text="role" /></td>
            <td><form:select path="role" items="${allRoles}" itemValue="id" itemLabel="name" /></td>
            <td><form:errors path="role" cssClass="error" /></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Add User"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>