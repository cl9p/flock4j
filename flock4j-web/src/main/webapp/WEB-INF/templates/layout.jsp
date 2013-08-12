<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Flock - A Cloud Automation Tool</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Stormin Normin">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true" /></title>

    <!-- Javascript -->
    <script src="/static/javascript/jquery.js" type="text/javascript"></script>
    <script src="/static/javascript/bootstrap.js" type="text/javascript"></script>

    <!-- CSS -->
    <link href="/static/css/application.css" media="all" rel="stylesheet" type="text/css" />
    <link href="/static/css/bootstrap.css" media="all" rel="stylesheet" type="text/css" />
    <link href="/static/css/custom.css" media="all" rel="stylesheet" type="text/css" />
    <link href="/static/css/bootstrap.css" media="all" rel="stylesheet" type="text/css" />
    <link href="/static/css/custom.css" media="all" rel="stylesheet" type="text/css" />

    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="/static/images/cloud_nine_partners-small-ico.png">
</head>
<body>
<div id="wrap">
    <div class="navbar navbar-inverse navbar-fixed-top">
        <tiles:insertAttribute name="header" />
    </div>
    <tiles:insertAttribute name="content" />
</div>
<div class="navbar navbar-fixed-bottom cl9p">
    <tiles:insertAttribute name="footer" />
</div>
</body>
</html>