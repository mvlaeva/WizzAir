<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>AirLines | Baggage</title>
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
		<header>
			<div class="wrapper">
				<h1>
					<a href="./Home" id="logo">AirLines</a>
				</h1>
				<span id="slogan">Fast, Frequent &amp; Safe Flights</span>
				<nav id="top_nav">
					<ul>
						<c:if test="${ empty user  }">
							<li><a href="./Login" class="nav2">Login</a></li>
						</c:if>
						<c:if test="${ not empty user }">
							<li><a href="./Logout" class="nav2">Logout</a></li>
						</c:if>
						<li><a href="./Contacts" class="nav3">Contact</a></li>
					</ul>
				</nav>
			</div>
			<nav>
				<ul id="menu">
					<li><a href="./Home"><span><span>About</span></span></a></li>
					<li><a href="./Offers"><span><span>Offers</span></span></a></li>
					<li><a href="./Book"><span><span>Book</span></span></a></li>
					<li><a href="./Safety"><span><span>Safety</span></span></a></li>
					<li class="end"><a href="./Contacts"><span><span>Contacts</span></span></a></li>
					<c:if test="${not empty user }">
						<li id="menu_active"><a href="./Profile"><span><span>Profile</span></span></a></li>
					</c:if>
				</ul>
			</nav>
		</header>
		<!-- / header -->
		<!--content -->
		<section id="content">
			<div class="wrapper pad1">
				<article class="col1">
					<div class="box1">
						<h2 class="top">Hot Offers of the Week</h2>
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
											<c:if test="${not empty mapFlights}">
												<form action="./Buy" method="post">
												<!-- SEARCH CHILDREN -->
													<c:forEach begin="1" end="${search.adults}"
														varStatus="loop">
														<div style="padding-left: 30px;">
															<p style="font-size: 16px;">
																<strong>Passanger <c:out value="${loop.index}" />
																	(Adult)
																</strong>
															</p>
															<br>
															<c:if test="${not empty buyMessage }">
																<p style="color: red">
																	<c:out value="${ buyMessage}"></c:out>
																</p>
															</c:if>
															<p>
																<label>First Name</label> <input type="text"
																	name="firstName<c:out value="${loop.index}" />"
																	placeholder="<c:out value="${firstName}" />" />
															</p>
															<p>
																<label>Last Name</label> <input type="text"
																	name="lastName<c:out value="${loop.index}" />"
																	placeholder="<c:out value="${lastName}" />" />
															</p>
															<p>
																Gender <input type="radio"
																	name="gender<c:out value="${loop.index}" />"
																	value="male" checked> MALE <input type="radio"
																	name="gender<c:out value="${loop.index}" />"
																	value="female"> FEMALE <br>
															</p>
															<p>
																Cabin baggage <input type="radio"
																	name="cabinBaggage<c:out value="${loop.index}" />"
																	value="small" checked> SMALL <input
																	type="radio"
																	name="cabinBaggage<c:out value="${loop.index}" />"
																	value="large"> LARGE <br>
															</p>
															<p>
																CheckIn baggage <input type="radio"
																	name="chechedInBaggage<c:out value="${loop.index}" />"
																	value="LIGHT" checked> LIGHT <input
																	type="radio"
																	name="chechedInBaggage<c:out value="${loop.index}" />"
																	value="HEAVY"> HEAVY <br>
															</p>
															<p>
																Sports equipment <input type="checkbox"
																	name="sportsEquipment<c:out value="${loop.index}" />"
																	id="sportsEquipment"> <label
																	for="sportsEquipment"></label>
															</p>
															<p>
																Check-in method<input type="radio"
																	name="checkIn<c:out value="${loop.index}" />"
																	value="online" checked> Online <input
																	type="radio"
																	name="checkIn<c:out value="${loop.index}" />"
																	value="airport"> Airport <br>
															</p>
														</div>
														<hr></hr>
													</c:forEach>
													<input type="submit" value="Continue" />
												</form>
											</c:if>
											<c:if test="${ empty mapFlights}">
												<div>
													<c:out value="You chose no flights!"></c:out>
												</div>
											</c:if>
										</c:if>
										<c:if test="${empty user }">
											<div>
												<c:out value="Please first login to reserve a ticket!"></c:out>
											</div>
											<form action="./Login" method="post">
												<input type="submit" value="Login">
											</form>
										</c:if>
										<c:if test="${ adults <= 0 }">
											<p>
												<c:out value="You chose no number of adults!" />
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
		<footer>
			<div class="wrapper">
				<ul id="icons">
					<li><a href="https://www.facebook.com/wizzaircom"
						class="normaltip"><img src="images/icon1.jpg" height="30"
							width="30" alt=""></a></li>
					<li><a href="https://twitter.com/wizzair" class="normaltip"><img
							src="images/icon2.jpg" height="30" width="30" alt=""></a></li>
					<li><a href="https://www.youtube.com/user/WizzAirCorporate"
						class="normaltip"><img src="images/icon3.jpg" height="30"
							width="30" alt=""></a></li>
				</ul>
			</div>
		</footer>
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