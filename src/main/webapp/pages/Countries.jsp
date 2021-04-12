<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Countries</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
	<p>Logged user: ${username}</p>
	<p><a href="/World/pages/City.jsp">City Search</a>
	<a href="/World/pages/Continents.jsp">Continents Search</a></p>
	<form action="/World/Countries">
		<label for="country">Country:</label>
		<input type="text" name="country" />
		<label for="continent">Continent:</label>
		<input type="text" name="continent" /> 
		<input type="submit" value="Search" />
	</form>
	<c:choose>
		<c:when test="${empty countryList && empty error}">
		 <p>Search for countries Data.</p>
		</c:when>
		<c:when test="${error != null}">
		 <p>${error}</p>
		</c:when>
		<c:otherwise>
			<table cellspacing="20px">
				<tr>
					<td>Name:</td>
					<td>Country Code:</td>
					<td>Continent:</td>
					<td>Population:</td>
					<td>Surface Area:</td>
				</tr>
				<c:forEach items="${countryList}" var="country">
				<tr>
					<td>${country.name}</td>
					<td>${country.code}</td>
					<td>${country.continent}</td>
					<td>${country.population}</td>
					<td>${country.surfaceArea}</td>
				</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>