<%--
  Created by IntelliJ IDEA.
  User: Tran Hiep
  Date: 17/07/2022
  Time: 10:33 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2><a href="authors?action=create">Tao moi</a></h2>
<h1>Danh sach tac gia</h1>
<c:forEach var="author" items="${authorList}">
    <h3>${author.id}, ${author.name}, ${author.dateOfBirth}, ${author.numberOfArts}, ${author.nation}, ${author.image}
        <a href="/authors?action=edit&id=${author.id}">Edit</a> <a href="/authors?action=delete&id=${author.id}">Delete</a></h3>
</c:forEach>
</body>
</html>
