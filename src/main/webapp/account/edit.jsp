<%--
  Created by IntelliJ IDEA.
  Account: ADMIN
  Date: 2022-07-08
  Time: 04:33 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Account</title>
</head>
<body>
<center>
    <h1>Account Management</h1>
    <h2>
        <a href="/accounts?action=accounts">List All Accounts</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Edit Account</h2>
            </caption>
            <c:if test="${account != null}">
                <input type="hidden" name="id" value="<c:out value='${account.id}' />"/>
            </c:if>
            <tr>
                <th>Full Name:</th>
                <td>
                    <input type="text" name="fullName" id="fullName" size="45"
                           value="<c:out value='${account.fullName}'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>UserName:</th>
                <td>
                    <input type="text" name="username" id="username" size="45"
                           value="<c:out value='${account.username}'/>" />
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"
                           value="<c:out value='${account.email}'/>" />
                </td>
            </tr>
            <tr>
                <th>Password:</th>
                <td>
                    <input type="text" name="password" id="password" size="45"
                           value="<c:out value='${account.password}'/>" />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45"
                           value="<c:out value='${account.address}'/>" />
                </td>
            </tr>
            <tr>
                <th>Phone Number:</th>
                <td>
                    <input type="text" name="phoneNumber" id="phoneNumber" size="45"
                           value="<c:out value='${account.phoneNumber}'/>" />
                </td>
            </tr>
            <tr>
                <th>Role ID:</th>
                <td>
                    <input type="text" name="role" id="role" size="45"
                           value="<c:out value='${account.roleId}'/>" />
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
