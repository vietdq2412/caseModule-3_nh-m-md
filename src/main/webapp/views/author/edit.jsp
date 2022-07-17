<%--
  Created by IntelliJ IDEA.
  User: Tran Hiep
  Date: 17/07/2022
  Time: 11:01 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <input type="hidden" name="id" value="${author.id}">
    <label>Name</label>
    <input type="text" name="name" value="${author.name}"><br>
    <label>Date of birth</label>
    <input type="date" name="date_of_birth" value="${author.dateOfBirth}"><br>
    <label>Number of arts</label>
    <input type="number" name="number_of_arts" value="${author.numberOfArts}"><br>
    <label>Nation</label>
    <input type="text" name="nation" value="${author.nation}"><br>
    <label>Image</label>
    <input type="text" name="image" value="${author.image}"><br>
    <button>Xac nhan thay doi</button>
</form>
</body>
</html>
