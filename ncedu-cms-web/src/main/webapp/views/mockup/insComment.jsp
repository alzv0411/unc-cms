<%-- 
    Document   : insComment
    Created on : 09.12.2014, 15:58:50
    Author     : Sacred
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="inscomment" method="post" >
             <p><input  type="text" name="id" placeholder="Введите commentId"></p>
             <p><input  type="text" name="pageId" placeholder="Введите pageId"></p>
             <p><input  type="text" name="comment" placeholder="Введите comment"></p>
             <p><input  type="text" name="createdBy" placeholder="Введите createdBy"></p>
             <p><input  type="text" name="modifiedBy" placeholder="Введите modifiedBy"></p>
            <p><input type="submit" value="Добавить"></p>      
        </form>
    </body>
</html>
