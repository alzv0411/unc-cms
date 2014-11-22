<%-- 
    Document   : right
    Created on : Nov 22, 2014, 5:48:35 PM
    Author     : dmitry
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rights ${right.firstName}</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>Group ID:</td>
                <td>${right.groupId}</td>
            </tr>
            <tr>
                <td>Page ID:</td>
                <td>${page.pageId}</td>
            </tr>
            <tr>
                <td>Read:</td>
                <td>${right.read}</td>
            </tr>
            <tr>
                <td>Write:</td>
                <td>${right.write}</td>
            </tr>
        </table>
    </body>
</html>
