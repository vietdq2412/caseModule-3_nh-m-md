<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Edit Book</title>
</head>
<body>
<center>
    <h1>Book Management</h1>
    <h2>
        <a href="/books?action=accounts">List All Book</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Book</h2>
            </caption>
            <c:if test="${book != null}">
                <input type="hidden" name="id" value="<c:out value='${book.id}' />"/>
            </c:if>
            <tr>
                <th>Title:</th>
                <td>
                    <input type="text" name="title" id="title" size="45"
                           value="<c:out value='${book.title}'/>"/>
                </td>
            </tr>
            <tr>
                <th>CategoryID:</th>
                <td>
                    <select name="categoryId" id="categoryId">
                        <option value="${book.categoryId.id}"><c:out value='${book.categoryId.name}'/></option>
                    </select>
<%--                    <input type="text" name="categoryId" id="categoryId" size="45"--%>
<%--                           value="<c:out value='${book.categoryId}'/>"/>--%>

                </td>
            </tr>
            <tr>
                <th>AuthorID:</th>
                <td>
                    <select name="authorId" id="authorId">
                        <option value="${book.authorId.id}"><c:out value='${book.authorId.name}'/></option>
                    </select>
<%--                    <input type="text" name="authorId" id="authorId" size="45"--%>
<%--                           value="<c:out value='${book.authorId}'/>"/>--%>
                </td>
            </tr>
            <tr>
                <th>Publish Year:</th>
                <td>
                    <input type="text" name="publishYear" id="publishYear" size="45"
                           value="<c:out value='${book.publishYear}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <input type="text" name="description" id="description" size="45"
                           value="<c:out value='${book.description}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Image:</th>
                <td>
                    <input type="text" name="image" id="image" size="45"
                           value="<c:out value='${book.image}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Views:</th>
                <td>
                    <input type="text" name="views" id="views" size="45"
                           value="<c:out value='${book.views}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td>
                    <input type="text" name="quantity" id="quantity" size="45"
                           value="<c:out value='${book.quantity}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="price" id="price" size="45"
                           value="<c:out value='${book.price}'/>"/>
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
