<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="movieId" scope="session" value="${movie.movieId}"/>
	${movie.movieId}
	<form action="${contextPath}/updateMovie" method="post">
		<table>
			<tr>
				<td>Movie Name:</td>
				<td><input type="text" name="movieName" value="${movie.movieName }" required="true" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input type="text " name="description" value="${movie.description }" required="true" /></td>
			</tr>
			<tr>
				<td>Genre:</td>
				<td><input type="text" name="genre" value="${movie.genre }" required="true"/></td>
			</tr>
			
			<tr>
			</tr>
				<td colspan="2"><input type="submit" value="Update Movie" /></td>
			</tr>
		</table>
	</form>
	
</body>
</html>