<%-- 
    Document   : attach
    Created on : Nov 18, 2014, 7:11:26 PM
    Author     : Viktor
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <title>Users ${attachment.firstName}</title>
    </head>
     <body>
        <table border="1">
            <tr>
                <td>Attach ID:</td>
                <td>${attachment.attachmentId}</td>
            </tr>
            <tr>
                <td>Page ID</td>
                <td>${attachment.pageId}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>${attachment.name}</td>
            </tr>
            <tr>
                <td>filepath:</td>
                <td>${attachment.filepath}</td>
            </tr>
            <tr>
   
        </table>
    </body>
</html>
