<%-- 
    Document   : login
    Created on : 21.11.2014, 16:37:44
    Author     : Roman Semenov <romansemenov3@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login, please</h1><br>
        <form method="post" action="login">
            <table>
                <tr>
                    <td style="text-align: right">
                        Email:
                    </td>
                    <td style="text-align: left">
                        <input type="text" name="login">
                    </td>
                </tr>
                <tr>
                    <td style="text-align: right">
                        Password:
                    </td>
                    <td style="text-align: left">
                        <input type="password" name="password">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <center><input type="submit" name="Login" value="Login"></center>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center">
                        ${loginStatusText}
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center">
                        Current groupId: ${currentGroup}
                    </td>
                </tr>
            </table>
        </form>
        <hr>
        <form method="post" action="login?action=logout">
            <input type="submit" name="Logout" value="Logout">
        </form>
    </body>
</html>
