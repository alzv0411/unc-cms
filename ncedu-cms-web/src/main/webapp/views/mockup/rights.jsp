<%-- 
    Document   : rights
    Created on : Nov 22, 2014, 6:06:08 PM
    Author     : dmitry
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All rights</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>Group ID</td>
                <td>Page ID</td>
                <td>Read</td>
                <td>Write</td>
            </tr>
            <c:forEach items="${rights}" var="right">
                <tr>
                    <td>${right.groupId}</td>
                    <td>${right.pageId}</td>
                    <td>${right.read}</td>
                    <td>${right.write}</td>
                </tr>
            </c:forEach>
    </table>
    </body>
</html>
