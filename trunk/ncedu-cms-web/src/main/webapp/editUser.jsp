<%-- 
    Document   : editUser
    Created on : Dec 2, 2014, 9:29:29 PM
    Author     : Viktor
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action = "EditUserServlet">
            <table>
                <tr>
                    <td style="text-align: right">
                        UserId:
                    </td>
                    <td style="text-align: left">
                        <input type="text" name="userId" value ="${userId}" readonly >
                        
                    </td>
                </tr>
                <tr>
                    <td style="text-align: right">
                        Firstname:
                    </td>
                    <td style="text-align: left">
                        <input type="text" name="firstname" value ="${firstname}" >
                        
                    </td>
                </tr>
                <tr>
                    <td style="text-align: right">
                        Lastname:
                    </td>
                    <td>
                        <input type="text" name="lastname" value ="${lastname}">
                    </td>
                </tr>
                <tr>
                    <td style="text-align: right">
                        Email:
                    </td>
                    <td>
                        <input type="text" name="email" value ="${email}">
                    </td>
                </tr>
                <tr>
                    
                    <td style="text-align: right">
                        Password:
                    </td>
                    <td style="text-align: left">
                        <input type="password" name="password" value ="${password}">
                    </td>
                </tr>  
                <tr>
                    
                    <td style="text-align: right">
                        GroupId:
                    </td>
                    <td style="text-align: left">
                        <input type="text" name="groupId" value ="${groupId}">
                    </td>
                </tr> 
                <tr>
                    <td colspan = "2">
                       <input type = "submit" value = "Edit">                     
                    </td>
                </tr> 
            </table>
        </form>
    </body>
</html>
