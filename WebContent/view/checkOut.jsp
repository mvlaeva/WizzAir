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

		<c:set var="price" scope="session" value="${200}" />

		<div>
			<c:forEach items="${pickedFlights}" var="flight">
				<div class="padding_flight" style="width: 500px">
					<br>
				</div>
				<div class="flight">
					<br>
					<p class="flight">
						Id :<c:out value="${flight.id}" />
					</p>	
					<p class="flight">
						Origin Station :
						<c:out value="${flight.originStation}" />
					</p>
					<p class="flight">
						Destination Station :
						<c:out value="${flight.destinationStation}" />
					</p>
					<p class="flight">
						Departure :
						<c:out value="${flight.departure}" />
					</p>
					<p class="flight">
						Arrival :
						<c:out value="${flight.arrival}" />
					</p>
					<p class="flight">
						Duration :
						<c:out value="${flight.duration} minutes" />
					</p>
					<p class="flight">
						Carrier :
						<c:out value="WizzAir" />
					</p>
					<p class="flight">
						Price :
						<c:out value="${flight.price}" />
					</p>

					<br>
				</div>
			</c:forEach>
			<p>
				Price :
				<c:out value="${price}" />
			</p>
		</div>
		<input type="submit" value="Pay" />
	</form>


</body>
</html>