<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html lang="en">
<head>
<title><spring:message code="baggage.title"/></title>
<meta charset="utf-8">
<link href="<c:url value="/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/css/layout.css" />" rel="stylesheet">
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/css/regform.css" />" rel="stylesheet">
<!-- Include the jQuery file -->

<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>

<!-- Include the jquery.placeholder.js file -->

<script src="https://code.jquery.com/jquery.placeholder.js"
	type="text/javascript"></script>
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
				<article class="col2">
					<div class="tabs2">
						<article>
							<div>
								<div class="content">
									<div class="tab-content" id="Flight"
										style="background: white; border: 1px solid #63aeca;">
										<c:if test="${not empty user }">
											<c:if test="${not empty pickedFlights}">
												<form action="./Buy" method="post">
													<c:forEach begin="1" end="${search.adults + search.children}"
														varStatus="loop">
														<div style="padding-left: 30px;">
															<p style="font-size: 16px;">
																<strong><spring:message code="baggage.passenger"/> <c:out value="${loop.index}" />
																<c:if test="${loop.index <= search.adults }">
																	<spring:message code="baggage.adult"/>
																</c:if>
																<c:if test="${loop.index > search.adults }">
																	<spring:message code="baggage.child"/>
																</c:if>
																	
																</strong>
															</p>
															<br>
															<c:if test="${not empty buyMessage }">
																<p style="color: red">
																	<c:out value="${ buyMessage}"></c:out>
																</p>
															</c:if>
															<p>
																<label><spring:message code="baggage.firstName"/></label> <input type="text"
																	name="firstName<c:out value="${loop.index}" />"
																	placeholder="<c:out value="${firstName}" />" />
															</p>
															<p>
																<label><spring:message code="baggage.lastName"/></label> <input type="text"
																	name="lastName<c:out value="${loop.index}" />"
																	placeholder="<c:out value="${lastName}" />" />
															</p>
															<p>
																<spring:message code="baggage.gender"/> <input type="radio"
																	name="gender<c:out value="${loop.index}" />"
																	value="male" checked> <spring:message code="baggage.gender.male"/> <input type="radio"
																	name="gender<c:out value="${loop.index}" />"
																	value="female"> <spring:message code="baggage.gender.female"/> <br>
															</p>
															<p>
																<spring:message code="baggage.cabinBag"/> <input type="radio"
																	name="cabinBaggage<c:out value="${loop.index}" />"
																	value="small" checked> <spring:message code="baggage.cabinBag.small"/> <input
																	type="radio"
																	name="cabinBaggage<c:out value="${loop.index}" />"
																	value="large"> <spring:message code="baggage.cabinBag.large"/> <br>
															</p>
															<p>
																<spring:message code="baggage.checkInBag"/> <input type="radio"
																	name="chechedInBaggage<c:out value="${loop.index}" />"
																	value="LIGHT" checked><spring:message code="baggage.checkInBag.light"/><input
																	type="radio"
																	name="chechedInBaggage<c:out value="${loop.index}" />"
																	value="HEAVY"><spring:message code="baggage.checkInBag.heavy"/><br>
															</p>
															<p>
																<spring:message code="baggage.sportEquipment"/> <input type="checkbox"
																	name="sportsEquipment<c:out value="${loop.index}" />"
																	id="sportsEquipment"> <label
																	for="sportsEquipment"></label>
															</p>
															<p>
																<spring:message code="baggage.checkIn"/><input type="radio"
																	name="checkIn<c:out value="${loop.index}" />"
																	value="online" checked><spring:message code="baggage.checkIn.online"/><input
																	type="radio"
																	name="checkIn<c:out value="${loop.index}" />"
																	value="airport"><spring:message code="baggage.checkIn.airport"/><br>
															</p>
														</div>
														<hr></hr>
													</c:forEach>
													<input type="submit" value="<spring:message code="baggage.continue"/>" />
												</form>
											</c:if>
											<c:if test="${empty mapFlights}">
												<div>
												<spring:message code="baggage.message" var="baggage"/>
													<c:out value="${baggage}"></c:out>
												</div>
											</c:if>
										</c:if>
										<c:if test="${empty user }">
											<div>
											<spring:message code="baggage.login" var="login"/>
												<c:out value="${login}"></c:out>
											</div>
											<form action="./Login" method="post">
												<input type="submit" value="Login">
											</form>
										</c:if>
										<c:if test="${ adults <= 0 }">
											<p>
											<spring:message code="baggage.adults" var="adults"/>
												<c:out value="${adults}" />
											</p>
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
		$(function() {
			var openedInputs = $("input:text");
			for (var i = 0; i < openedInputs.length; i++) {
				var openedPlaceholder = openedInputs[i].placeholder;

				if (openedInputs[i].value == "") {
					openedInputs[i].value = openedPlaceholder;
				}
			}
		});
	</script>
</body>
</html>