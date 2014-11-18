<%-- 
    Document   : settings
    Created on : 16.11.2014, 22:48:09
    Author     : daemon
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All settings</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>Name</td>
                <td>Value</td>
            </tr>
            <c:forEach items="${settings}" var="setting">
                <tr>
                    <td>${setting.name}</td>
                    <td>${setting.value}</td>
                </tr>
            </c:forEach>
    </table>
    </body>
</html>
