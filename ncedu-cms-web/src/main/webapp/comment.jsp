<%-- 
    Document   : comment
    Created on : Nov 18, 2014, 0:00:00 PM
    Author     : Roman Semenov <romansemenov3@gmail.com>
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comment ${comment.commentId}</title>
    </head>
    <body>
        <table border ="1">
            <tr>
                <td>CommentId:</td>
                <td>${comment.commentId}</td>
            </tr>
            <tr>
                <td>Page:</td>
                <td>${comment.pageId}</td>
            </tr>
            <tr>
                <td>Comment:</td>
                <td>${comment.comment}</td>
            </tr>
            <tr>
                <td>Created by:</td>
                <td>${comment.createdBy}</td>
            </tr>
            <tr>
                <td>Created when:</td>
                <td><fmt:formatDate value="${comment.createdWhen}" pattern="yyyy-MM-dd"/></td>
            </tr>
            <tr>
                <td>Modified by:</td>
                <td>${comment.modifiedBy}</td>
            </tr>
            <tr>
                <td>Modified when:</td>
                <td><fmt:formatDate value="${comment.modifiedWhen}" pattern="yyyy-MM-dd"/></td>
            </tr>
        </table>
    </body>
</html>
