<%-- 
    Document   : users
    Created on : Nov 9, 2014, 11:30:27 PM
    Author     : Alexander Zvyagintsev <alzv0411@gmail.com>
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All users</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>User ID</td>
                <td>Email</td>
                <td>Password</td>
                <td>Group ID</td>
                <td>Firstname</td>
                <td>Lastname</td>
                <td>Register when</td>
                <td>Last login</td>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <td>${user.groupId}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td><fmt:formatDate value="${user.registerWhen}" pattern="yyyy-MM-dd"/></td>
                    <td><fmt:formatDate value="${user.lastLogin}" pattern="yyyy-MM-dd"/></td>
                </tr>
            </c:forEach>
    </table>
</body>
</html>
