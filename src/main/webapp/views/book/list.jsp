<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book Management Application</title>
</head>
<body>
<center>
    <h1>Book Management</h1>
    <h2>
        <a href="/books?action=create">Add New Book</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Book</h2></caption>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Category ID</th>
            <th>Author ID</th>
            <th>Publish Year</th>
            <th>Description</th>
            <th>Image</th>
            <th>Views</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="book" items="${listBook}">
            <tr>
                <td><c:out value="${book.id}"/></td>
                <td><c:out value="${book.title}"/></td>
                <td><c:out value="${book.categoryId.name}"/></td>
                <td><c:out value="${book.authorId.name}"/></td>
                <td><c:out value="${book.publishYear}"/></td>
                <td><c:out value="${book.description}"/></td>
                <td><c:out value="${book.image}"/></td>
                <td><c:out value="${book.views}"/></td>
                <td><c:out value="${book.quantity}"/></td>
                <td><c:out value="${book.price}"/></td>
                <td>
                    <a href="/books?action=edit&id=${book.id}">Edit</a>
                    <a href="/books?action=delete&id=${book.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>