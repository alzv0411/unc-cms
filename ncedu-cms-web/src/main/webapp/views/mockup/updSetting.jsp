<%-- 
    Document   : updSetting
    Created on : Dec 8, 2014, 11:19:33 PM
    Author     : dmitry
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Setting</title>
    </head>
    <body>
        <form action="updsetting" method="post">             
            <p><input  type="text" name="name" value="${name}" readonly></p>
            <p><input  type="text" name="value" value="${value}"></p>
            <p><input type="submit" value="Изменить"></p>
        </form>
    </body>
</html>
