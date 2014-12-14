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
                <td>Update</td>
                <td>Delete</td>                
            </tr>
            <c:forEach items="${settings}" var="setting">
                <tr>
                    <td>${setting.name}</td>
                    <td>${setting.value}</td>
                    <td><a href="http://localhost:8080/ncedu-cms-web/updsetting?named=${setting.name}">Upd</a></td>
                    <td><a href="http://localhost:8080/ncedu-cms-web/delsetting?name=${setting.name}">Del</a></td>
                </tr>
            </c:forEach>
    </table>
    <hr> 
    <form action="inssetting" method="post" >
        <p><input type="submit" value="Добавить"></p>
    </form>
    </body>
</html>
