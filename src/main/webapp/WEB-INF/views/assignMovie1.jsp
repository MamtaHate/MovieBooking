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
<%@ page session="true" %>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="audiList" scope="session" value="${audiList}"/>
	<form action="${contextPath}/assignAudi" method="post"
		>
		<table>
			<tr>
				<td>Movie Name:</td>
				<td>	
				<select name="movie">
					<c:forEach items="${movieList}" var="movie">
					<c:if test="${selectedMovie == movie.movieName }">  
					     <option selected value="${movie.movieName}">${movie.movieName}</option>
					</c:if>  
					    <option value="${movie.movieName}">${movie.movieName}</option>					    
					</c:forEach>
				<select>
				</td>
			</tr>
			   
			<tr>
				<td>Theater Name:</td>
				<td>	
				<select name="theater" >
					<c:forEach items="${theaterList}" var="theater">					
					    <option value="${theater.theaterName}">${theater.theaterName}</option>					    			
				
				</c:forEach>
				</select>
				</td>
			</tr>
			
			<tr>
				<td>Auditorium:</td>
				<td>	
				<select name="audi">
					<c:forEach items="${audiList}" var="audi">
					    <option value="${audi.audiName}">${audi.audiName}</option>					    
					</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td>Price:</td>
				<td>	
				<input type="number" name="price"/>
				</td>
			</tr>
			<tr>
				<td>Showtime:</td>
				<td>
					<select name="showtime">
							<option value="9:00pm-12:00pm" >9:00pm-12:00pm</option>
							<option value="12:00pm-3:00pm" >12:00pm-3:00pm</option>
							<option value="3:00pm-6:00pm" >3:00pm-6:00pm</option>
							<option value="6:00pm-9:00pm" >6:00pm-9:00pm</option>
							<option value="9:00pm-12:00pm" >9:00pm-12:00pm</option>
					</select>
				</td>
			</tr> 
			 
				<td colspan="2"><input type="submit" value="Add Movie to Theater" /></td>
			</tr>
		</table>
	</form>
</body>
</html>