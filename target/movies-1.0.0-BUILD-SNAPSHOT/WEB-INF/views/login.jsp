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
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
${loginError}
		<form action="${contextPath}/login.htm" method="POST">
            <label> Username :  </label><input type="text" name="username" />
            <label> Password :  </label><input type="password" name="password" />
            
            <input type="submit" value="Login" name="login"/>
            
            
            <input type="submit" value="Register" name="register"/>
        </form>
</body>
</html>