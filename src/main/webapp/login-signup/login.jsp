<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<div align="center">
    <form action="/accounts?action=login" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h1>Login</h1>
            </caption>
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
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                        <a href="/accounts?action=signup">SignUp</a>
                </td>

            </tr>
        </table>
    </form>
    </form>
</div>

</body>
</html>