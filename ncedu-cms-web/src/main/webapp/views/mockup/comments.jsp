<%-- 
    Document   : comments
    Created on : Nov 18, 2014, 0:00:00 PM
    Author     : Roman Semenov <romansemenov3@gmail.com>
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All users</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>CommentId</td>
                <td>PageId</td>
                <td>Comment</td>
                <td>CreatedBy</td>
                <td>CreatedWhen</td>
                <td>ModifiedBy</td>
                <td>ModifiedWhen</td>
                <td>DELETE</td>
                <td>UPDATE</td>
            </tr>
            <c:forEach items="${comments}" var="comment">
                <tr>
                    <td>${comment.commentId}</td>
                    <td>${comment.pageId}</td>
                    <td>${comment.comment}</td>
                    <td>${comment.createdBy}</td>
                    <td><fmt:formatDate value="${comment.createdWhen}" pattern="yyyy-MM-dd"/></td>
                    <td>${comment.modifiedBy}</td>
                    <td><fmt:formatDate value="${comment.modifiedWhen}" pattern="yyyy-MM-dd"/></td>
                    <td>  <a href="http://localhost:8080/ncedu-cms-web/delcomment?id=${comment.commentId}">del</a></td>
                    <td>  <a href="http://localhost:8080/ncedu-cms-web/updcomment?id=${comment.commentId}">Upd</a></td>
                </tr>
            </c:forEach>
    </table>
        <hr> 
        <form action="../insComment.jsp" method="post" >
            <p><input type="submit" value="Добавить"></p>      
        </form>
</body>
</html>
