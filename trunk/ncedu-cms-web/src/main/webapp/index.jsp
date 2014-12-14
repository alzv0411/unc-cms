<%--
    Document   : index
    Created on : Nov 9, 2014, 10:40:40 PM
    Author     : Alexander Zvyagintsev <alzv0411@gmail.com>
--%>
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
        Welcome page
    </title>
</head>
<body>
<div id="header">
    <div id="pagename">
        Welcome page
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
                    'data' :[
                        { "id" : "ajson2", "parent" : "#", "text" : "Welcome page", 'state' : { 'opened' : true} },
                        { "id" : "ajson3", "parent" : "ajson2", "text" : "Page 1" },
                        { "id" : "ajson4", "parent" : "ajson2", "text" : "Page 2" },
                    ]
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
            <h1>Links:</h1>

            <p><a href="/${pageContext.request.contextPath}/mockup/user">Users</a></p>

            <p><a href="/${pageContext.request.contextPath}/mockup/setting">Settings</a></p>

            <p><a href="/${pageContext.request.contextPath}/mockup/group">Groups</a></p>

            <p><a href="/${pageContext.request.contextPath}/mockup/comment">Comments</a></p>

            <p><a href="/${pageContext.request.contextPath}/mockup/attachment">Attachments</a></p>

            <p><a href="/${pageContext.request.contextPath}/mockup/right">Right</a></p>

            <p><a href="/${pageContext.request.contextPath}/login">Login</a></p>

            <p style="font-size:10px"><a href="/${pageContext.request.contextPath}/site">maybe a site's design</a></p>
        </div>
    </div>
</div>
<div id="footer">
    unc-cms ©
</div>
</body>
</html>
