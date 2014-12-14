<%-- 
    Document   : pages
    Created on : Nov 20, 2014, 6:37:33 PM
    Author     : ReinierDay
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All pages</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>Page ID</td>
                <td>Parent ID</td>
                <td>Title</td>
                <td>Content</td>
                <td>Created by</td>
                <td>Created when</td>
                <td>Modified by</td>
                <td>Modified when</td>
                <td>Properties</td>
            </tr>
            <c:forEach items="${pages}" var="page">
                <tr>
                    <td>${page.pageId}</td>
                    <td>${page.parentId}</td>
                    <td>${page.title}</td>
                    <td>${page.content}</td>
                    <td>${page.createdBy}</td>
                    <td><fmt:formatDate value="${page.createdWhen}" pattern="yyyy-MM-dd"/></td>
                    <td>${page.modifiedBy}</td>
                    <td><fmt:formatDate value="${page.modifiedWhen}" pattern="yyyy-MM-dd"/></td>
                    <td>${page.properties}</td>
                </tr>
            </c:forEach>
    </table>
</body>
</html>
