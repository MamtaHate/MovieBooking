<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<a href="${contextPath}/addTheaterPage"><button type="button">Add Theater</button></a>

<a href="${contextPath}/addMoviePage"><button type="button">Add Movie</button></a>

<a href="${contextPath}/updateMoviePage"><button type="button">Update Movie</button></a>

<a href="${contextPath}/removeMovieAssigned"><button type="button">Remove Movie from Theater</button></a>

<a href="${contextPath}/assignMovie"><button type="button">Add movie to Theater</button></a>

<a href="${contextPath}/logout"><button type="button">Logout</button></a>

</body>
</html>