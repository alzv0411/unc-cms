<%-- 
    Document   : insGroup
    Created on : 02.12.2014, 18:46:02
    Author     : Sacred
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="insgroup" method="post">
                            
             <p><input  type="text" name="groupId" ></p>
             <p><select name="parentId" method="post" >
                   <c:forEach items="${groups}" var="group">
 
                     <option>${group.parentId}</option>
                     
                   </c:forEach>
                </select>
             </p>                 
             <p><input  type="text" name="name" ></p>                
             <p><input type="submit" value="Добавить"></p>               
        </form>
    </body>
</html>
