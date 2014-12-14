<%-- 
    Document   : user
    Created on : Nov 9, 2014, 11:13:58 PM
    Author     : Alexander Zvyagintsev <alzv0411@gmail.com>
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users ${user.firstName}</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>User ID:</td>
                <td>${user.userId}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${user.email}</td>
            </tr>
            <tr>
                <td>Password:</td>
                <td>${user.password}</td>
            </tr>
            <tr>
                <td>Group ID:</td>
                <td>${user.groupId}</td>
            </tr>
            <tr>
                <td>Firstname:</td>
                <td>${user.firstName}</td>
            </tr>
            <tr>
                <td>Lastname:</td>
                <td>${user.lastName}</td>
            </tr>
            <tr>
                <td>Register when:</td>
                <td><fmt:formatDate value="${user.registerWhen}" pattern="yyyy-MM-dd"/></td>
            </tr>
            <tr>
                <td>Last login:</td>
                <td><fmt:formatDate value="${user.lastLogin}" pattern="yyyy-MM-dd"/></td>
            </tr>
        </table>
    </body>
</html>
