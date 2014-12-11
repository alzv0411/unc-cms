<%-- 
    Document   : insSetting
    Created on : Dec 8, 2014, 11:14:07 PM
    Author     : dmitry
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Setting</title>
    </head>
    <body>
        <form action="inssetting" method="post">
             <p>Setting name: </p>
             <input  type="text" name="name" >
             <p>Setting value: </p>
             <input  type="text" name="value" >
             <p><input type="submit" value="Добавить"></p>
        </form>
    </body>
</html>
