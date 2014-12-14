<%--
    Document   : index
    Created on : Nov 9, 2014, 10:40:40 PM
    Author     : Alexander Zvyagintsev <alzv0411@gmail.com>
--%>
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
    ${page.title}
  </title>
</head>
<body>
<div id="header">
  <div id="pagename">
    ${page.title}
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
      <p>${page.content}</p>

      <p>Page information:</p>
      <table>
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
        <tr>
          <td>Read:</td>
          <td>${right.read}</td>
        </tr>
        <tr>
          <td>Write:</td>
          <td>${right.write}</td>
        </tr>
      </table>
    </div>
  </div>
</div>
<div id="footer">
  unc-cms ©
</div>
</body>
</html>
