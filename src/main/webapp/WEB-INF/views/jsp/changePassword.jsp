<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>AirLines | Profile</title>
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
						<div style="padding-bottom: 30px">
							<div
								style="padding-bottom: 30px; padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
								<legend>
									<a href="./ViewHistory"><spring:message code="changepass.viewHistory"/></a>
								</legend>
							</div>
							<div
								style="padding-bottom: 30px; padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
								<legend>
									<spring:message code="changepass.changePass"/>
								</legend>
							</div>
							<div
								style="padding-bottom: 30px; padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
								<legend>
									<a href="./ChangeEmail"><spring:message code="changepass.changeMail"/></a>
								</legend>
							</div>
							<div
								style="padding-bottom: 30px; padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
								<legend>
									<a href="./ChangePhone"><spring:message code="changepass.phone"/></a>
								</legend>
							</div>
						</div>
					</div>
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
					style="margin-bottom: 250px; margin-left: 400px; padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
					<div class="profile_info">
						<div>
							<div style="margin-right: 70px">
								<c:if test="${not empty passMessage }">
									<p>
										<c:out value="${passMessage }"></c:out>
									</p>
								</c:if>
								<p
									style="padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
									<strong> New password: </strong>
								<form action="./ChangePassword" method="post">
									<input type="password" name="password" placeholder="password">
									<p>
										<input type="submit" value="Change Password">
									</p>
								</form>
								</p>
							</div>
						</div>
					</div>
				</article>

				<article
					style="margin-left: 400px; padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
					<div class="profile_info">
						<div>
							<p style="padding-left: 0px;">
								<strong><legend>Profile info</legend></strong>
							</p>
							<div style="margin-right: 70px">
								<p
									style="padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
									<strong> Username: </strong>
									<c:out value="${ username}"></c:out>
								</p>
								<p
									style="padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
									<strong> Email: </strong>
									<c:out value="${ email}"></c:out>
								</p>
								<p
									style="padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
									<strong> First name: </strong>
									<c:out value="${ firstName}"></c:out>
								</p>
								<p
									style="padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
									<strong> Last name: </strong>
									<c:out value="${ lastName}"></c:out>
								</p>
								<p
									style="padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
									<strong> Phone number: </strong>
									<c:out value="${ phone}"></c:out>
								</p>
								<br>
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
</body>
</html>