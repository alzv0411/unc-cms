<%-- 
    Document   : UpdGroup
    Created on : 02.12.2014, 18:45:02
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
        <form action="updgroup" method="post">             
            <p><input  type="text" name="groupId" value= "${groupId}" readonly></p>
             <p>
                 <select name="parentId"  >
                      <option selected > ${parentNum}</option>
                   <c:forEach items="${groups}" var="group">

                       <option > ${group.parentId}</option>
                     
                   </c:forEach>
                     
                     
                </select>
                
             </p>                 
             <p><input  type="text" name="name" value= "${name}"  ></p>
             
             <p><input type="submit" value="Изменить"></p>               
        </form>
    </body>
</html>
