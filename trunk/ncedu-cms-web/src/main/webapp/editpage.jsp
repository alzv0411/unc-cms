<%-- 
    Document   : editor
    Created on : 07.12.2014, 7:40:15
    Author     : Roman Semenov <romansemenov3@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <script src="http://srv:8080/ncedu-cms-web/js/tinymce/tinymce.min.js"></script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Page editor</h1>
        <c:choose>
            <c:when test="${page != null}">
                <script>
                    tinymce.init({
                            selector: "textarea",
                            theme: "modern",
                            plugins: [
                                    "advlist autolink link image lists charmap print preview hr anchor pagebreak save spellchecker",
                                    "searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking",
                                    "table contextmenu directionality emoticons template paste textcolor importcss"
                            ],
                            add_unload_trigger: false,

                            toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image | print preview media fullpage | forecolor backcolor emoticons table",
                    });
                </script>
                <form method="post" action="editpage?id=${page.pageId}">
                    <table>
                        <tr>
                            <td style="text-align: right">
                                Title:
                            </td>
                            <td style="text-align: left">
                                <input type="text" name="title" value="${page.title}">
                            </td>
                        </tr>
                    </table>
                    <textarea name="content" style="width:100%">${page.content}</textarea><br/>
                    <table>
                        <tr>
                            <td>
                                <input type="submit" name="SavePage" value="Save this page">
                            </td>
                </form>
                <form method="post" action="deletepage?id=${page.pageId}">
                            <td>
                                <input type="submit" name="DeletePage" value="Delete this page">
                            </td>
                        </tr>
                    </table>
                </form>
                    
            </c:when>
            <c:otherwise>
                Page does not exist. Would you like to add new page?
            </c:otherwise>
        </c:choose>        
        <hr/>
        <table>
            <tr>
                <td>
                    
                </td>
                <td>
                    <form method="post" action="addpage">
                        <input type="submit" name="AddPage" value="Add new page">
                    </form>
                </td>
            </tr>
        </table>        
    </body>
</html>
