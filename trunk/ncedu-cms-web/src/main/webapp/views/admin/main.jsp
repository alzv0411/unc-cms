<%--
    Document   : index
    Created on : Nov 9, 2014, 10:40:40 PM
    Author     : Alexander Zvyagintsev <alzv0411@gmail.com>
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <link href='http://fonts.googleapis.com/css?family=Fira+Mono|Roboto:400,300,700,900&subset=latin,cyrillic'
        rel='stylesheet' type='text/css'>
  <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
  <link href='style/style.css' rel='stylesheet' type='text/css'>
  <link href='style/uncstyle.css' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/8.4/styles/github.min.css">
  <link rel="stylesheet" href="dist/themes/default/style.min.css" />
  <script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/8.4/highlight.min.js"></script>
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  <script src="dist/jstree.min.js"></script>
  <script>hljs.initHighlightingOnLoad();</script>
  <title>
    Administration console
  </title>
</head>
<body>
<div id="header">
  <div id="pagename">
    Administration console
  </div>
  <div id="header_tools">
    <div id="searchbox">
      <i class="fa fa-search"></i>
      <input id="searchform" placeholder="Search...">
    </div>
    <div id="userdata">
      <i class="fa fa-user"></i>
      Profile
    </div>
  </div>
</div>

<div id="content_wrapper">
  <div id="navigation">
    <div id="jstree_demo_div"></div>
    <script>
      $('#jstree_demo_div').jstree({
        'core' : {
          'data' : ${jsTreeData}
        }
      });
      $('#jstree_demo_div').on("changed.jstree", function (e, data) {
        console.log(data.selected);
      });
    </script>
  </div>
  <div id="container">
    <div id="breadcrumbs">
      <i class="fa fa-home"></i>
      no breadcrumbs 4 ya
    </div>
    <div id="content">
      <table border="1">
        <tr>
          <td>User ID</td>
          <td>Email</td>
          <td>Password</td>
          <td>Group ID</td>
          <td>Firstname</td>
          <td>Lastname</td>
          <td>Register when</td>
          <td>Last login</td>
          <td>Edit</td>
          <td>Delete</td>
        </tr>

        <c:forEach items="${users}" var="user">
          <tr>
            <td name>${user.userId}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.groupId}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td><fmt:formatDate value="${user.registerWhen}" pattern="yyyy-MM-dd"/></td>
            <td><fmt:formatDate value="${user.lastLogin}" pattern="yyyy-MM-dd"/></td>
            <td><a href = "/${pageContext.request.contextPath}/EditUserServlet?id=${user.userId}">Edit</a></td>
            <td><a href = "/${pageContext.request.contextPath}/DeleteUserServlet?id=${user.userId}">Delete</a></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </div>
</div>
<div id="footer">
  unc-cms ©
</div>
</body>
</html>
