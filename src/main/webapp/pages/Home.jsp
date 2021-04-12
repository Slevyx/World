<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
	<p>Welcome, please enter your name.</p>
	<form action="/World/Home" method="POST">
	<input type="text" name="login" /> <input type="submit" value="Login" />
	</form>
	<c:if test="${not empty error}">
		<p>${error}</p>
	</c:if>
</body>
</html>