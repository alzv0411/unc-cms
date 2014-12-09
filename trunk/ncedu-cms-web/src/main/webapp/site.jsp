<%-- 
    Document   : site
    Created on : 01.12.2014, 10:27:34
    Author     : daemon
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
  <meta charset="utf-8" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link href='http://fonts.googleapis.com/css?family=Fira+Mono|Roboto:400,300,700,900&subset=latin,cyrillic' rel='stylesheet' type='text/css'>
  <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
  <link href='style/style.css' rel='stylesheet' type='text/css'>
  <link href='style/uncstyle.css' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/8.4/styles/github.min.css">
  <script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/8.4/highlight.min.js"></script>
  <script>hljs.initHighlightingOnLoad();</script>
  <title>
    %pagename% | unc-cms
  </title>
</head>
<body>
  <div id = "header">    
    <div id = "pagename">
      %pagename% | unc-cms
    </div>
    <div id = "header_tools">
      <div id = "searchbox">
        <i class="fa fa-search"></i>
        <input id="searchform" placeholder = "Search..."></input>
      </div>
      <div id = "userdata">
        <i class="fa fa-user"></i>
        Profile
      </div>
    </div>
  </div>
    
  <div id = "content_wrapper">
    <div id = "navigation">
      here goes nav
    </div>
    <div id = "container">
      <div id = "breadcrumbs">
        <i class="fa fa-home"></i>
        no breadcrumbs 4 ya
      </div>
      <div id = "content">
        <h2>Progress bars</h2>
        
        <h3>Regular progress bar</h3>
        <div class="unc-example">
          <div class="progressbar">
            <div class="progress" style="width: 50%">
            </div>
          </div>
        </div>
        <div class="highlight">
          <pre><code>&lt;div class="progressbar">
  &lt;div class="progress" style="width: 50%">
  &lt;/div>
&lt;/div></code></pre>
        </div>        
        
        <h3>Small size danger</h3>
        <div class="unc-example">
          <div class="progressbar progress-small">
            <div class="progress danger" style="width: 30%">
            </div>
          </div>
        </div>
        <div class="highlight">
          <pre><code>&lt;div class="progressbar progress-small">
  &lt;div class="progress danger" style="width: 30%">
  &lt;/div>
&lt;/div></code></pre>
        </div>
        
        <h3>Standart size success</h3>
        <div class="unc-example">
          <div class="progressbar">
            <div class="progress success" style="width: 50%;">
              50%
            </div>
          </div>
        </div>
        <div class="highlight">
          <pre><code>&lt;div class="progressbar">
  &lt;div class="progress success" style="width: 50%;">
    50%
  &lt;/div>
&lt;/div></code></pre>
        </div>
        
        <h3>Large size warning</h3>
        <div class="unc-example">
          <div class="progressbar progress-large">
            <div class="progress warning" style="width: 70%;">
              70%
            </div>
          </div>
        </div>
        <div class="highlight">
          <pre><code>&lt;div class="progressbar progress-large">
  &lt;div class="progress warning" style="width: 70%;">
    70%
  &lt;/div>
&lt;/div></code></pre>
        </div>
        
        <h3>Standart size 0% progress bar</h3>
        <div class="unc-example">
          <div class="progressbar">
            <div class="progress" style="width: 0%;">
              0%
            </div>
          </div>
        </div>
        <div class="highlight">
          <pre><code>&lt;div class="progressbar">
  &lt;div class="progress" style="width: 0%;">
    0%
  &lt;/div>
&lt;/div></code></pre>
        </div>
        
        
        <h2>Buttons</h2>
        
        <div class="unc-example">
          <button>Normal</button>
          <button class="button-large success">Success</button>
          <button class="button-giant warning">Warning</button>
          <button class="button-small danger">Danger</button>
          <button class="button-tiny info">Info</button>
          <button class="primary">Primary</button>
        </div>
        <div class="highlight">
          <pre><code>&lt;button>Normal&lt;/button>
&lt;button class="button-large success">Success&lt;/button>
&lt;button class="button-giant warning">Warning&lt;/button>
&lt;button class="button-small danger">Danger&lt;/button>
&lt;button class="button-tiny info">Info&lt;/button>
&lt;button class="primary">Primary&lt;/button></code></pre>
        </div>
        
        <h2>Callout</h2>
        <div class="unc-example">
          <div class="callout callout-info">
            <h3>Info callout</h3>
            <p>There goes regular text just to show that it works.</p>
          </div>
          <div class="callout callout-warning">
            <h3>Warning callout</h3>
            <p>There goes regular text just to show that it works.</p>
          </div>
          <div class="callout callout-danger">
            <h3>Danger callout</h3>
            <p>There goes regular text just to show that it works.</p>
          </div>
        </div>
        <div class="highlight">
          <pre><code>&lt;div class="callout callout-info">
  &lt;h3>Info callout&lt;/h3>
  &lt;p>There goes regular text just to show that it works.&lt;/p>
&lt;/div>
&lt;div class="callout callout-warning">
  &lt;h3>Warning callout&lt;/h3>
  &lt;p>There goes regular text just to show that it works.&lt;/p>
&lt;/div>
&lt;div class="callout callout-danger">
  &lt;h3>Danger callout&lt;/h3>
  &lt;p>There goes regular text just to show that it works.&lt;/p>
&lt;/div></code></pre>
        </div>
        
        <h2>Checkboxes and radio buttons</h2>
        <div class="unc-example">
          <div class="unc-input unc-input-small">
            <input type="text" placeholder="Small text input">
          </div>
          <div class="unc-input unc-input-regular">
            <input type="text" placeholder="Text input">
          </div>
          <div class="unc-input unc-input-large">
            <input type="text" placeholder="Large text input">
          </div>
        </div>
        
        <div class="highlight">
<pre><code>&lt;input type="text" class="unc-text-input unc-text-input-small" placeholder="Small text input">
&lt;input type="text" class="unc-text-input" placeholder="Text input">          
&lt;input type="text" class="unc-text-input unc-text-input-large" placeholder="Large text input">
</code></pre>
        </div>
      </div>
  </div>
 </div>   
  <div id = "footer">
    unc-cms ©
  </div>
</body>
</html>
