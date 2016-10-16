<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title><spring:message code="book.title"/></title>
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
						<article class="col1">
							<div class="tabs">
								<ul class="nav">
									<li class="selected"><a href="#Flight"><spring:message code="index.flight"/></a></li>
								</ul>
								<div class="content" style="width: 400px"">
									<div class="tab-content" id="Flight">
										<form id="form_1" action="./SearchController" method="post">
											<div>
												<div class="radio">
													<div class="wrapper">
														<input type="radio" name="name1" checked> <span>One-way</span>
														<input type="radio" name="name1"> <span>With
															transfer</span>
													</div>
												</div>
												<div class="row">
													<span class="left"><spring:message code="index.from"/></span> <input type="text"
														class="input" name="origin">
												</div>
												<div class="row">
													<span class="left"><spring:message code="index.to"/></span> <input type="text"
														class="input" name="destination">
												</div>
												<div class="wrapper">
													<div class="col1">
													<div>
														<div class="row">
															<span class="left"><spring:message code="index.outbound"/></span> <input type="date"
																id="datepicker" class="input1" name="departureDate">
														</div>
														<div class="row">
															<span class="left"><spring:message code="index.return"/></span> <input type="text"
																class="input1" value="2016-10-18" name="returnDate"
																onblur="if(this.value=='') this.value='2016-10-18'"
																onFocus="if(this.value =='2016-10-18' ) this.value=''">
														</div>
													</div>
												</div>
												<div class="row">
													<span class="left"><spring:message code="index.adults"/></span> <select name="adults">
														<option value="1">1</option>
														<option value="2">2</option>
														<option value="3">3</option>
													</select>
												</div>
												<div class="row">
													<span class="left"><spring:message code="index.children"/> <spring:message code="index.children.years"/></span> <select
														name="children">
														<option value="0">0</option>
														<option value="1">1</option>
														<option value="2">2</option>
														<option value="3">3</option>
													</select>
												</div>
												<div class="row">
													<span class="left"><spring:message code="index.stops"/></span> <select name="stops">
														<option value="0">0</option>
														<option value="1">1</option>
														<option value="2">2</option>
														<option value="3">3</option>
													</select>
												</div>
												<div class="wrapper"></div>
											</div>
											<input type="submit" value="<spring:message code="index.search"/>" />
										</form>
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