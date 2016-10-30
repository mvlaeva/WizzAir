<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="checkOut.title"/></title>
<meta charset="utf-8">
<link href="<c:url value="/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/css/layout.css" />" rel="stylesheet">
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/css/regform.css" />" rel="stylesheet">
<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<style type="text/css">.main, .tabs ul.nav a, .content, .button1, .box1, .top { behavior:url("../js/PIE.htc")}</style>
<![endif]-->
</head>
<body id="page5">
	<div class="main">
		<!--header -->
	<jsp:include page="header.jsp" />
		<!-- / header -->
		<!--content -->
		<section id="content">
			<div class="wrapper pad1">
				<article class="col1">
					<div class="box1">
						<h2 class="top"><spring:message code="index.offersOfWeek"/></h2>
						<div class="pad">
							<strong>Birmingham</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 143.-</span> <a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>London (LCY)</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 176.-</span> <a
									href="book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 109.-</span> <a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>London (LHR)</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 100.-</span> <a
									href="book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 112.-</span> <a
									href="book2.html">Zurich</a></li>
								<li><span class="right color1">from GBP 88.-</span> <a
									href="book2.html">Basel</a></li>
							</ul>
							<strong>Manchester</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 97.-</span> <a
									href="book2.html">Basel</a></li>
								<li><span class="right color1">from GBP 103.-</span> <a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>Edinburgh</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 165.-</span> <a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>Birmingham</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 143.-</span> <a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>London (LCY)</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 176.-</span> <a
									href="book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 109.-</span> <a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>London (LHR)</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 100.-</span> <a
									href="book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 112.-</span> <a
									href="book2.html">Zurich</a></li>
								<li><span class="right color1">from GBP 88.-</span> <a
									href="book2.html">Basel</a></li>
							</ul>
						</div>
					</div>
				</article>
				<article
					style="margin-left: 400px; padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
					<div class="profile_info">
						<div>
							<p>
								<spring:message code="checkOut.numPass"/>
								<c:out value="${fn:length(adultPassengers)}" />
							</p>
							<div class="padding_flight" style="width: 500px">
											<br>
										</div>
							<form action="./Pay" method="post">
								<c:set var="price" scope="session"
									value="${(pickedFlights[0].price * fn:length(adultPassengers)) }" />
								<div>							
									<c:forEach items="${pickedFlights}" var="flight">
										
										<div
											style="display:inline-block; float: left; padding: 2px 2px 2px 2px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5); bаckground: white; border: 1px solid; border-radius: 5px 20px 5px; border-color: #6b7b8d;">
											<br>
											<p
												style="padding: 2px 2px 2px 2px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5); bаckground: white; border: 1px solid; border-radius: 5px 20px 5px; border-color: #6b7b8d;">
												Direction :
												<c:out value="${flight.directionality}" />
											</p>
											<p
												style="padding: 2px 2px 2px 2px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5); bаckground: white; border: 1px solid; border-radius: 5px 20px 5px; border-color: #6b7b8d;">
												Origin Station :
												<c:out value="${flight.originStation}" />
											</p>
											<p
												style="padding: 2px 2px 2px 2px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5); bаckground: white; border: 1px solid; border-radius: 5px 20px 5px; border-color: #6b7b8d;">
												Destination Station :
												<c:out value="${flight.destinationStation}" />
											</p>
											<p
												style="padding: 2px 2px 2px 2px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5); bаckground: white; border: 1px solid; border-radius: 5px 20px 5px; border-color: #6b7b8d;">
												Departure :
												<c:out value="${flight.departure}" />
											</p>
											<p
												style="padding: 2px 2px 2px 2px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5); bаckground: white; border: 1px solid; border-radius: 5px 20px 5px; border-color: #6b7b8d;">
												Arrival :
												<c:out value="${flight.arrival}" />
											</p>
											<p
												style="padding: 2px 2px 2px 2px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5); bаckground: white; border: 1px solid; border-radius: 5px 20px 5px; border-color: #6b7b8d;">
												Duration :
												<c:out value="${flight.duration} minutes" />
											</p>
											<p
												style="padding: 2px 2px 2px 2px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5); bаckground: white; border: 1px solid; border-radius: 5px 20px 5px; border-color: #6b7b8d;">
												Carrier :
												<c:forEach items="${flight.carriers}" var="carrier" >
													 <c:out value="${carrier}" />																	  
												</c:forEach>
											</p>
											<p
												style="padding: 2px 2px 2px 2px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5); bаckground: white; border: 1px solid; border-radius: 5px 20px 5px; border-color: #6b7b8d;">
												Price :
												<fmt:formatNumber type="number" maxFractionDigits="2"
													value="${flight.price}" />
											</p>
											<br>
										</div>
									</c:forEach>
									
								</div>
									<p style="display:inline-block; float: right;">
										<strong><spring:message code="checkOut.total"/></strong>
										<fmt:formatNumber type="number" maxFractionDigits="2"
											value="${ price}" />
									</p>
								<input type="submit" value="<spring:message code="checkOut.book"/>" />
							</form>
							<!--  
							<form action="./PayViaCard" method="post">
								<input type="submit" value="Pay via credit/debit card">
							</form>
							-->
						</div>
					</div>
				</article>
			</div>
		</section>
		<!--content end-->
		<!--footer -->
	<jsp:include page="footer.jsp" />
		<!--footer end-->
	</div>
	<script type="text/javascript">
		Cufon.now();
	</script>
</body>
</html>