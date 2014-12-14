<%-- 
    Document   : setting
    Created on : 16.11.2014, 22:47:41
    Author     : daemon
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Settings ${setting.name}</title>
    </head>
    <body>
        <table border ="1">
            <tr>
                <td>Setting:</td>
                <td>${setting.name}</td>
            </tr>
            <tr>
                <td>Value:</td>
                <td>${setting.value}</td>
            </tr>
        </table>
    </body>
</html>
