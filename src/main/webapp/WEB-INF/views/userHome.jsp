<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

${success}<br>

<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<a href="${contextPath}/viewBooking"><button type="button">View Bookings</button></a>
<a href="${contextPath}/logout">
<button type="button">Logout</button>
</a>


<form:form action="${contextPath}/browseMovies" method="post" modelAttribute="movie">
		<table>
			<tr>
				<td>Search Movie:</td>
				<td><form:input type="text" path="movieName" required="true"
				placeholder="search by name, genre" /></td>
			</tr>
			<td><label path = "searchBy">Search By</label></td>
               <td>
                  <input type="radio" name = "searchBy" value = "searchByGenre" />Genre
                  <input type="radio" name = "searchBy" value = "searchByMovie" />Movie Name
               </td>
               
			<tr>
				<td colspan="2"><input type="submit" value="Search Movie" /></td>
			</tr>
			
		</table>
</form:form>

	 <c:if test="${not empty moviesList}">
		<c:forEach items="${moviesList}" var="movie" >
		   <img alt="no" src="${ movie.fileName }" width="50%" height="50%"> 
		   Movie: ${movie.movieName}
		   Genre: ${movie.genre }<c:out value="${movie.genre }"></c:out>
		   Description: ${movie.description} <c:out value="${movie.description }"></c:out>
	id ${movie.movieId}
		   <c:set var="movieId" scope="session" value="${movie.movieId}"/>
		   <c:set var="movieName" scope="session" value="${movie.movieName}"/>
		   <a href="${contextPath}/bookShow?movieId=${movie.movieId}">Book show</a> 
		</c:forEach>
	</c:if>
	<c:if test="${not empty movieOne}">  
	 
	<img alt="no" src="${ movieOne.fileName }" width="50%" height="50%"> 
	   Movie: <c:out value="${movieOne.movieName}"/>
	   Genre: <c:out value="${movieOne.genre }"></c:out>
	   Description: <c:out value="${movieOne.description }"></c:out>
	   id ${movieName.movieId}
	   <c:set var="movieId" scope="session" value="${movieOne.movieId}"/>
	   <c:set var="movieName" scope="session" value="${movieOne.movieName}"/>
	   <a href="${contextPath}/bookShow?movieId=${movieOne.movieId}">Book show</a>   
</c:if> 


</body>
</html>