<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Continents</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
	<p>Logged user: ${username}</p>
	<p><a href="/World/pages/City.jsp">City Search</a>
	<a href="/World/pages/Countries.jsp">Countries Search</a>
	<a href="/World/pages/Continents.jsp">Continents Search</a></p>
	<c:if test="${!isCountriesList && !isCitiesList}">
		<div class="continent-list">
			<p>Continent List:</p>
			<a href="/World/Continent?continentName=Europe">Europe</a> <a
				href="/World/Continent?continentName=Asia">Asia</a> <a
				href="/World/Continent?continentName=Africa">Africa</a> <a
				href="/World/Continent?continentName=North America">North America</a>
			<a href="/World/Continent?continentName=South America">South
				America</a> <a href="/World/Continent?continentName=Oceania">Oceania</a>
			<a href="/World/Continent?continentName=Antarctica">Antarctica</a>
		</div>
	</c:if>
	<c:if test="${isCountriesList && not empty error || isCitiesList && not empty error}">
		<p>${error}</p>
	</c:if>
	<c:if test="${isCountriesList && empty error}">
		<table cellspacing="20px">
			<tr>
				<td>Name:</td>
				<td>Country Code:</td>
				<td>Population:</td>
			</tr>
			<c:forEach items="${countryList}" var="country">
				<tr>
					<td><a href="/World/Cities?countryCode=${country.code}">${country.name}</a></td>
					<td>${country.code}</td>
					<td>${country.population}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${isCitiesList && empty error}">
		<table cellspacing="20px">
			<tr>
				<td>Name:</td>
				<td>Population:</td>
			</tr>
			<c:forEach items="${citiesList}" var="city">
				<tr>
					<td>${city.name}</td>
					<td>${city.population}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>