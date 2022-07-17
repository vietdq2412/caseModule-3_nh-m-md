<%--
  Created by IntelliJ IDEA.
  Account: ADMIN
  Date: 2022-07-08
  Time: 03:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Account</title>
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
                <h2>Add New Account</h2>
            </caption>
            <tr>
                <th>Full Name:</th>
                <td>
                    <input type="text" name="fullName" id="fullName" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Username:</th>
                <td>
                    <input type="text" name="username" id="username" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Password:</th>
                <td>
                    <input type="text" name="password" id="password" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Phone Number:</th>
                <td>
                    <input type="text" name="phoneNumber" id="phoneNumber" size="45"/>
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
