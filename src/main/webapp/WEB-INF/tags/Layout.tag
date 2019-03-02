<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="title" fragment="true" %>
<%@attribute name="scripts" fragment="true" %>

<html xmlns="http://www.w3.org/1999/xhtml"
	  xmlns:th="http://www.thymeleaf.org">
	<head>
		<title><jsp:invoke fragment="title"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="icon" href="/img/favicon.ico">
		<link href="/lib/materialize/materialize.min.css" rel="stylesheet">
	</head>
	<body>
	<header>
		<nav class="transparent black-text">
			<jsp:invoke fragment="header"/>
		</nav>
	</header>
	<div class="container">
		<jsp:doBody/>
	</div>
	<footer style="background-color: white" class="page-footer">
		<div class="container">
			<div class="grey-text center-align">
				<span class="">Hossein Azizollahi (C) 2019 All rights reserved</span>
			</div>
		</div>
	</footer>
	<jsp:invoke fragment="scripts"/>
	</body>
	<script src="/lib/materialize/materialize.min.js" language="JavaScript"></script>
	<script src="/js/scripts.js" language="JavaScript"></script>
</html>