<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.wizzair.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check luggage</title>
</head>
<body>
				<form action="" method="post">
				<c:forEach begin="1" end="${search.adults}" varStatus="loop">
			
				<div>
					<div>
						<p> Passanger <c:out value="${loop.index}"/> </p>
						<label>First Name</label>
						<input type="text" name="firstName" placeholder="First Name" />
						<label>Last Name</label>
						<input type="text" name="lastName" placeholder="Last Name" />
						<c:forEach var="state" items="${Gender.values()}">
	    						<c:out value="${state}" />
						</c:forEach>
					</div>
					<div>
					<p> Cabin baggage </p>
						<c:forEach var="state" items="${CabinBaggage.values()}" >
    						<c:out value="${state}" />
						</c:forEach>
					</div>
				</div>
				<br>
				</c:forEach>		
					<%--<div>
					<c:if test="${ not empty allFlights }">
						<c:forEach items="${allFlights}" var="flight">
							<div>
								<p class="flight"> Id : <c:out value="${flight.id}" /></p>
									<p class="flight"> Origin Station : <c:out value="${flight.originStation}" /></p>
									<p class="flight"> Destination Station : <c:out value="${flight.destinationStation}" /></p>
									<p class="flight"> Departure : <c:out value="${flight.departure}" /></p>
									<p class="flight"> Arrival : <c:out value="${flight.arrival}" /></p>
									<p class="flight"> Duration : <c:out value="${flight.duration}" /></p>
									<p class="flight"> Carrier : <c:out value="${flight.carriers}" /></p>
									<p class="flight"> Price : <c:out value="${flight.price}" /></p>
								<br>
							</div>
						</c:forEach>
					</c:if>
				</div> --%>
		
				<%-- 	<c:forEach items="${mapFlights}" var="flight">
							<div class="padding_flight">
								<br> 
								<p class="flight"> Id : <c:out value="${flight.key}" /></p>						
								<br>
							</div>
					</c:forEach> --%>
					
					
				
				<input type="submit" value="Continue" />
			</form>
</body>
</html>				