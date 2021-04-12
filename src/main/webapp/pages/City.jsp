<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>City</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
	<p>Logged user: ${username}</p>
	<p><a href="/World/pages/Countries.jsp">Countries Search</a>
	<a href="/World/pages/Continents.jsp">Continents Search</a></p>
	<form action="/World/City">
		<label for="city">City:</label>
		<input type="text" name="city" /> <input type="submit" value="Search" />
	</form>
	<c:choose>
		<c:when test="${empty city && empty error}">
		 <p>Search for cities Data.</p>
		</c:when>
		<c:when test="${error != null}">
		 <p>${error}</p>
		</c:when>
		<c:otherwise>
			<table cellspacing="20px">
				<tr>
					<td>Name:</td>
					<td>Country Code:</td>
					<td>District:</td>
					<td>Population:</td>
				</tr>
				<tr>
					<td>${city.name}</td>
					<td>${city.countryCode}</td>
					<td>${city.district}</td>
					<td>${city.population}</td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>