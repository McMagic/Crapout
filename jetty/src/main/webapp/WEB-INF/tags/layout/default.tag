<%@attribute name="content" required="true" fragment="true" %>
<%@attribute name="title" required="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>
	<head>
		<title>CrapOut!</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/css/stylesheet.css"/>"/>
	</head>
	<body>
		<div class="container">
			<div id="header">
				<a href="<c:url value="/"/>"><img id="header" src="<c:url value="/images/banner.png"/>"/></a>
			</div>
			<div id="menu">
				<div id="nav_link"><a href="<c:url value="/home"/>"/>Home</a></div>
				<div id="nav_link"><a href="<c:url value="/rules"/>"/>Rules</a></div>
				<div id="nav_link"><a href="<c:url value="/odds"/>"/>Odds</a></div>
				<div id="nav_link"><a href="<c:url value="/game"/>"/>Start Game</a></div>
			</div>
			<div id="content">
				<jsp:invoke fragment="content"/>
			</div>
		</div>
	</body>
</html>
