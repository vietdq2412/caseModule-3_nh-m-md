<%--
  Created by IntelliJ IDEA.
  Account: ADMIN
  Date: 2022-07-08
  Time: 03:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Book</title>
</head>
<body>
<center>
    <h1>Book Management</h1>
    <h2>
        <a href="/books?action=accounts">List All Accounts</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Book</h2>
            </caption>
            <tr>
                <th>Title:</th>
                <td>
                    <input type="text" name="title" id="title" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                    <select name="categoryId" id="categoryId">
                        <c:forEach var="category" items="${categories}">
                            <option value="${category.id}"><c:out value="${category.name}"/></option>
                        </c:forEach>
                    </select>
<%--                    <input type="text" name="categoryId" id="categoryId" size="45"/>--%>
                </td>
            </tr>
            <tr>
                <th>Author:</th>
                <td>
                    <select name="authorId" id="authorId">
                        <c:forEach var="author" items="${authors}">
                            <option value="${author.id}"><c:out value="${author.name}"/></option>
                        </c:forEach>
                    </select>
<%--                    <input type="text" name="authorId" id="authorId" size="45"/>--%>
                </td>
            </tr>
            <tr>
                <th>Publish Year:</th>
                <td>
                    <input type="text" name="publishYear" id="publishYear" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <input type="text" name="description" id="description" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Image:</th>
                <td>
                    <input type="text" name="image" id="image" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Views:</th>
                <td>
                    <input type="text" name="views" id="views" size="45"/>
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
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
    </form>
</div>
</body>
</html>
