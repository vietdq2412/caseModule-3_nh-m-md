<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Account Management Application</title>
</head>
<body>
<center>
    <h1>Account Management</h1>
    <h2>
        <a href="/accounts?action=create">Add New Account</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Account</h2></caption>
        <tr>
            <th>ID</th>
            <th>Full Name</th>
            <th>Username</th>
            <th>Email</th>
            <th>Password</th>
            <th>Address</th>
            <th>Phone Number</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="account" items="${listAccount}">
            <tr>
                <td><c:out value="${account.id}"/></td>
                <td><c:out value="${account.fullName}"/></td>
                <td><c:out value="${account.username}"/></td>
                <td><c:out value="${account.email}"/></td>
                <td><c:out value="${account.password}"/></td>
                <td><c:out value="${account.address}"/></td>
                <td><c:out value="${account.phoneNumber}"/></td>
                <td><c:out value="${account.roleId}"/></td>
                <td>
                    <a href="/accounts?action=edit&id=${account.id}">Edit</a>
                    <a href="/accounts?action=delete&id=${account.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>