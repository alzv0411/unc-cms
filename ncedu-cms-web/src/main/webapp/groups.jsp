<%-- 
    Document   : groups
    Created on : 18.11.2014, 17:04:54
    Author     : Sacred
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Groups</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>GroupId</td>
                <td>ParentId</td>
                <td>Name</td>
            </tr>
            
            <c:forEach items="${groups}" var="group">
                <tr>
                    <td>${group.groupId}</td>
                    <td>${group.parentId}</td>
                    <td>${group.name}</td>
                </tr>
            </c:forEach>
         </table>
    </body>
</html>
