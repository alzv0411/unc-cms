<%-- 
    Document   : page
    Created on : Nov 20, 2014, 6:30:53 PM
    Author     : ReinierDay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pages ${page.title}</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>Page ID:</td>
                <td>${page.pageId}</td>
            </tr>
            <tr>
                <td>Parent ID</td>
                <td>${page.parentId}</td>
            </tr>
            <tr>
                <td>Title:</td>
                <td>${page.title}</td>
            </tr>
            <tr>
                <td>Content:</td>
                <td>${page.content}</td>
            </tr>
            <tr>
                <td>Created by:</td>
                <td>${page.createdBy}</td>
            </tr>
            <tr>
                <td>Created when:</td>
                <td><fmt:formatDate value="${page.createdWhen}" pattern="yyyy-MM-dd"/></td>
            </tr>
            <tr>
                <td>Modified by:</td>
                <td>${page.modifiedBy}</td>
            </tr>
            <tr>
                <td>Modified when:</td>
                <td><fmt:formatDate value="${page.modifiedWhen}" pattern="yyyy-MM-dd"/></td>
            </tr>
            <tr>
                <td>Properties:</td>
                <td>${page.properties}</td>
            </tr>
        </table>
    </body>
</html>

