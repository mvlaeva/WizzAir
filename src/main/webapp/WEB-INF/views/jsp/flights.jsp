<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>AirLines | Flights</title>
<meta charset="utf-8">
<link href="<c:url value="/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/css/layout.css" />" rel="stylesheet">
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<style type="text/css">.main, .tabs ul.nav a, .content, .button1, .box1, .top { behavior:url("../js/PIE.htc")}</style>
<![endif]-->
</head>
<body id="page3">
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
								<li><span class="right color1">from GBP 143.-</span><a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>London (LCY)</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 176.-</span><a
									href="book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 109.-</span><a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>London (LHR)</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 100.-</span><a
									href="book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 112.-</span><a
									href="book2.html">Zurich</a></li>
								<li><span class="right color1">from GBP 88.-</span><a
									href="book2.html">Basel</a></li>
							</ul>
							<strong>Manchester</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 97.-</span><a
									href="book2.html">Basel</a></li>
								<li><span class="right color1">from GBP 103.-</span><a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>Edinburgh</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 165.-</span><a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>Birmingham</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 143.-</span><a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>London (LCY)</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 176.-</span><a
									href="book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 109.-</span><a
									href="book2.html">Zurich</a></li>
							</ul>
							<strong>London (LHR)</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 100.-</span><a
									href="book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 112.-</span><a
									href="book2.html">Zurich</a></li>
								<li><span class="right color1">from GBP 88.-</span><a
									href="book2.html">Basel</a></li>
							</ul>
						</div>
					</div>
				</article>
				<article class="col2">
					<div class="tabs2">
						<article>
							<div>
								<div class="content">
									<div class="tab-content" id="Flight">
										<form action="./Luggage" method="post">
											<div class="wrapper pad1">
												<div class="flight_info"
													style="background: white; border: 1px solid #63aeca;">
													<c:if test="${ not empty allFlights }">
														<c:forEach items="${allFlights}" var="flight">
															<div class="padding_flight" style="width: 500px">
																<br>
															</div>
															<div class="flight">																															
																<!--	<p>
																	<c:out value="${flight.stops}" />
																</p>
																-->
																<p class="flight">
																	<spring:message code="flight.origin"/>
																	<c:out value="${flight.originStation}" />
																</p>
																<p class="flight">
																	<spring:message code="flight.destination"/>
																	<c:out value="${flight.destinationStation}" />
																</p>
																<p class="flight">
																	<spring:message code="flight.departure"/>
																	<c:out value="${flight.departure}" />
																</p>
																<p class="flight">
																	<spring:message code="flight.arival"/>
																	<c:out value="${flight.arrival}" />
																</p>
																<p class="flight">
																	<spring:message code="flight.duration"/>
																	<c:out value="${flight.duration} minutes" />
																</p>
																<p class="flight">
																	<spring:message code="flight.carriers"/>
																	<c:out value="WizzAir" />
																</p>
																<p class="flight">
																	<spring:message code="flight.price"/>
																	<fmt:formatNumber type="number" maxFractionDigits="2"
																		value="${flight.price}" />
																</p>
																<div class="buy_now">				
																		<p>
																		<spring:message code="flight.choose"/>
																<input type="radio" name="outgoingFlightId" value="${flight.id}">
																	
															</p>
																</div>
																<br>
															</div>
														</c:forEach>
													</c:if>
												</div>
											</div>
											<c:if test="${ not empty allFlights }">
												<input type="submit" value="<spring:message code="baggage.continue"/>" />
											</c:if>
										</form>
										<c:if test="${empty allFlights }">
											<div class="flight_info" style="padding: 0">
												<p>
													<c:out
														value="<spring:message code="flight.noMatch"/>" />
												</p>
												<br>
												<form action="./index" method="get">
													<p>
														<input type="submit" value="<spring:message code="flight.newsearch"/>">
													</p>
												</form>
											</div>
										</c:if>
									</div>
								</div>
							</div>
						</article>
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
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$('.form_5').jqTransform({
				imgPath : 'jqtransformplugin/img/'
			});
		});
		$(document).ready(function() {
			tabs2.init();
		});
	</script>
</body>
</html>