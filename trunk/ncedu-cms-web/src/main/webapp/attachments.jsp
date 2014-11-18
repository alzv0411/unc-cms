<%-- 
    Document   : attachments
    Created on : Nov 9, 2014, 11:30:27 PM
    Author     : Viktor
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All attachments</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>Attachment ID</td>
                <td>Page ID</td>
                <td>Name</td>
                <td>Filepath</td>
                
            </tr>
            <c:forEach items="${attachments}" var="attachment">
                <tr>
                    <td>${attachment.attachmentId}</td>
                    <td>${attachment.pageId}</td>
                    <td>${attachment.name}</td>
                    <td>${attachment.filepath}</td>
                                     
                </tr>
            </c:forEach>
    </table>
</body>
</html>
