<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check out</title>
</head>
<body>

	<p>
		Number of passengers:
		<c:out value="${fn:length(adultPassengers)}" />
	</p>

	<form action="./Pay" method="post">
	
		<c:set var="price" scope="session" value="${200}"/>

		<div>
			<p> Price : <c:out value="${price}"/></p>
		</div>
		<input type="submit" value="Pay" />
	</form>


</body>
</html>