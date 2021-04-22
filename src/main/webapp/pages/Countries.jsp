<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Countries</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
	<h2>Welcome, ${loggedUser}!</h2>
	<a href="/World/pages/City.jsp"><button type="button" class="btn btn-danger">City</button></a>
	<a href="/World/pages/CountriesList.jsp"><button type="button" class="btn btn-warning">Countries</button></a>
	<a href="/World/continent"><button type="button" class="btn btn-dark">Continents</button></a>
	<h3>Countries information.</h3>
	<c:choose>
	<c:when test="${empty countries}">
		 <h4>Nothing was found.</h4>
		</c:when>
		<c:otherwise>
			<table class="table">
				<tr>
					<th scope="col">Country Name:</th>
				</tr>
				<c:forEach items="${countries}" var="country">
				<tr>
					<td><a class="text-primary text-decoration-none" href="/World/cities?countryCode=${country.code}">${country.name}</a></td>
				</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>