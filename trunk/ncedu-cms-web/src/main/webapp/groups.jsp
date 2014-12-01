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
        <script type="text/javascript">
                       function Updgroup() { 
                        var groupid = prompt('Введите id');
                        var parentid = prompt('Введите parentid');
                        var name1 = prompt('Введите name');
                        window.location = "http://localhost:8080/ncedu-cms-web/updgroup?id="+ groupid + "1;" + parentid + "2;"+ name1 + "3;";
                    }              
                        </script>
    </head>
    <body >
        
        <table border="1">
            <tr>
                <td>GroupId</td>
                <td>ParentId</td>
                <td>Name</td
            </tr>
            
            <c:forEach items="${groups}" var="group">
                <tr>
                    <td>${group.groupId}</td>
                    <td>${group.parentId}</td>
                    <td>${group.name}</td>
                </tr>
             </c:forEach>
         </table>
        <form action="insgroup" method="post">
                            
             <p><input  type="text" name="groupId" ></p>
             <p><input  type="text" name="parentId" ></p>                 
             <p><input  type="text" name="name" ></p>                
             <p><input type="submit" value="Добавить"></p>               
        </form>
        <form action="updgroup" method="post">
                            
             <p><input  type="text" name="groupId" ></p>
             <p><input  type="text" name="parentId" ></p>                 
             <p><input  type="text" name="name" ></p>                
             <p><input type="submit" value="Изменить"></p>               
        </form>
        <form action="delgroup" method="post">
                            
             <p><input  type="text" name="groupId" ></p>            
             <p><input type="submit" value="Удалить"></p>               
        </form>

    </body>
</html>
