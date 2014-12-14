<%-- 
    Document   : updComment
    Created on : 09.12.2014, 16:30:31
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
       <form action="updcomment" method="post" >
             <p><input  type="text" name="commentId" value="${commentId}" readonly ></p>
             <p><input  type="text" name="pageId" value="${pageId}"></p>
             <p><input  type="text" name="comment" value="${comment}"></p>
             <p><input  type="text" name="createdBy" value="${createdBy}"></p>
             <p><input  type="text" name="modifiedBy" value="${modifiedBy}"></p>
            <p><input type="submit" value="Добавить" ></p>      
        </form> 
    </body>
</html>
