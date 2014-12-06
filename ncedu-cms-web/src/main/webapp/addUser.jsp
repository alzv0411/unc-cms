<%-- 
    Document   : addUser
    Created on : Nov 25, 2014, 1:47:43 PM
    Author     : Viktor
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registration</h1>
        <form method="post" action = "InsertUserServlet">
            <table>
                <tr>
                    <td style="text-align: right">
                        UserId:
                    </td>
                    <td style="text-align: left">
                        <input type="text" name="userId">
                    </td>
                </tr>
                <tr>
                    <td style="text-align: right">
                        Firstname:
                    </td>
                    <td style="text-align: left">
                        <input type="text" name="firstname">
                    </td>
                </tr>
                <tr>
                    <td style="text-align: right">
                        Lastname:
                    </td>
                    <td>
                        <input type="text" name="lastname">
                    </td>
                </tr>
                <tr>
                    <td style="text-align: right">
                        Email:
                    </td>
                    <td>
                        <input type="text" name="email">
                    </td>
                </tr>
                <tr>
                    
                    <td style="text-align: right">
                        Password:
                    </td>
                    <td style="text-align: left">
                        <input type="password" name="password">
                    </td>
                </tr>  
                <tr>
                    
                     <td style="text-align: right">
                        GroupId:
                     </td>
                     <td style="text-align: left">
                        <input type="text" name="groupId">
                     </td>
                </tr> 
                <tr>
                    <td colspan = "2">
                       <input type = "submit" value = "Add">

                    </td>
                </tr> 
            </table>
        </form>
        
                
    </body>
</html>
