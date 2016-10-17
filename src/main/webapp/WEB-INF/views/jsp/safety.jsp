<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>AirLines | Safety</title>
<meta charset="utf-8">
<link href="<c:url value="/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/css/layout.css" />" rel="stylesheet">
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
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
					<h3 class="pad_top1">About Safety</h3>
					<div class="wrapper pad_bot2">
						<figure class="left marg_right1">
							<img src="images/page5_img1.jpg" alt="">
						</figure>
						<p>
							<strong><spring:message code="safety.h1"/></strong><br>
							<spring:message code="safety.h1.text"/>
						</p>
					</div>
					<div class="wrapper pad_bot2">
						<figure class="left marg_right1">
							<img src="images/page5_img2.jpg" alt="">
						</figure>
						<p>
							<strong><spring:message code="safety.h2"/></strong><br> 
							<spring:message code="safety.h2.text"/>
						</p>
					</div>
					<div class="wrapper">
						<a href="./Contacts" class="button1 right">
						<strong><spring:message code="safety.contact"/></strong></a>
					</div>
					<h3><spring:message code="safety.h3"/></h3>
					<p><spring:message code="safety.h3.text"/></p>
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