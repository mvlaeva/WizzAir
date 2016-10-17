<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<html>
<head>
<title><spring:message code="index.title"/></title>
<meta charset="utf-8">

<link href="<c:url value="/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/css/layout.css" />" rel="stylesheet">
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/css/jquery-ui.css" />" rel="stylesheet">
<script src="<c:url value="/js/jquery-ui.js"/>"></script>
<script src="<c:url value="/js/jquery-1.5.2.js"/>"></script>

<script src="<c:url value="https://code.jquery.com/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="https://code.jquery.com/ui/1.12.1/jquery-ui.js"/>"></script>


<%-- <script src="<c:url value='js/jquery-1.5.2.js'/>"</script> --%>
<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<style type="text/css">.main, .tabs ul.nav a, .content, .button1, .box1, .top { behavior:url("../js/PIE.htc")}</style>
<![endif]-->
</head>
<body id="page1">
	<script type="text/javascript">
	   $(document).ready(function () {
		    
	        $("#dt1").datepicker({
	            dateFormat: "yy-mm-dd",
	            minDate: 0,
	            onSelect: function (date) {
	                var date2 = $('#dt1').datepicker('getDate');
	                date2.setDate(date2.getDate() + 1);
	                $('#dt2').datepicker('setDate', date2);
	                //sets minDate to dt1 date + 1
	                $('#dt2').datepicker('option', 'minDate', date2);
	            }
	        });
	        $('#dt2').datepicker({
	            dateFormat: "yy-mm-dd",
	            onClose: function () {
	                var dt1 = $('#dt1').datepicker('getDate');
	                console.log(dt1);
	                var dt2 = $('#dt2').datepicker('getDate');
	                if (dt2 <= dt1) {
	                    var minDate = $('#dt2').datepicker('option', 'minDate');
	                    $('#dt2').datepicker('setDate', minDate);
	                }
	            }
	        });
	    });
	</script>
	<div class="main">
		<!--header -->
		<jsp:include page="header.jsp" />
		<!-- / header -->
		<!--content -->
		<c:if test="${ not empty viewHistoryMessage }">
			<div style="font-size: initial; padding: 15px;">
				<c:out value="${viewHistoryMessage }"></c:out>
			</div>
		</c:if>
		<c:if test="${not empty errorLog }">
			<div style="font-size: initial; padding: 15px;">
				<c:out value="${errorLog }"></c:out>
			</div>
		</c:if>
		<section id="content">
			<div class="for_banners">
				<article class="col1">
					<div class="tabs">
						<ul class="nav">
							<li class="selected"><a href="#Flight"><spring:message code="index.flight"/></a></li>
						</ul>
						<div class="content">
							<div class="tab-content" id="Flight">
								<form id="form_1" action="./SearchController" method="post">
									<div>
										<div class="radio">
											<div class="wrapper">	
											</div>
										</div>
										<div class="row">
											<span class="left"><spring:message code="index.from"/></span> <input type="text" id="text" 
												class="input" name="origin" list="suggestions" onkeyup="reloadSuggestions()">
										</div>
										<div class="row">
											<span class="left"><spring:message code="index.to"/></span> <input type="text" class="input"
												name="destination">
										</div>
										<div class="wrapper">
											<div class="col1">
												<div class="row">
													<span class="left"><spring:message code="index.outbound"/></span> 	
													<input type="text" id="dt1"	class="input1" name="departureDate" readonly="readonly">										
												</div>
												<div class="row">
													<span class="left"><spring:message code="index.return"/></span> 
													<input type="text" id="dt2" class="input1" name="returnDate" readonly="readonly">
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
											<span class="left"> <spring:message code="index.children"/> <spring:message code="index.children.years"/></span> <select
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
				<div id="slider">
					<img src="images/banner1.jpg" alt=""> <img
						src="images/banner2.jpg" alt=""> <img
						src="images/banner3.jpg" alt="">
				</div>
			</div>
			<div class="wrapper pad1">
				<article class="col1">
					<div class="box1">
						<h2 class="top"><spring:message code="index.offersOfWeek"/></h2>
						<div class="pad">
							<strong>From Birmingham</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 143.-</span> <a
									href="./Home">Zurich</a></li>
							</ul>
							<strong>From London City</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 176.-</span> <a
									href="./Home">Basel</a></li>
								<li><span class="right color1">from GBP 109.-</span> <a
									href="./Home">Geneva</a></li>
							</ul>
							<strong>From London Heathrow</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 100.-</span> <a
									href="./Home">Geneva</a></li>
								<li><span class="right color1">from GBP 112.-</span> <a
									href="./Home">Zurich</a></li>
								<li><span class="right color1">from GBP 88.-</span> <a
									href="./Home">Basel</a></li>
							</ul>
						</div>
						<h2>From Ireland To Switzerland</h2>
						<div class="pad">
							<strong>From Dublin</strong><br>
							<ul class="pad_bot2 list1">
								<li class="pad_bot1"><span class="right color1">from
										EUR 122.-</span> <a href="./Home">Zurich</a></li>
							</ul>
						</div>
					</div>
				</article>
				<article class="col2">
					<h3>
						<spring:message code="index.aboutAirlines"/><span></span>
					</h3>
					<div class="wrapper">
						<article class="cols">
							<figure>
								<img src="images/page1_img1.jpg" alt="" class="pad_bot2">
							</figure>
							<p class="pad_bot1">
								<strong><spring:message code="index.aboutAirlines.header1"/></strong>
							</p>
							<p><spring:message code="index.aboutAirlines.header1.text"/></p>
						</article>
						<article class="cols pad_left1">
							<figure>
								<img src="images/page1_img2.jpg" alt="" class="pad_bot2">
							</figure>
							<p class="pad_bot1">
								<strong><spring:message code="index.aboutAirlines.header2"/></strong>
							</p>
							<p><spring:message code="index.aboutAirlines.header2.text"/></p>
						</article>
					</div>
					<a href="./Safety" class="button1"><strong><spring:message code="index.button"/></strong></a>
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
		$(document).ready(function() {
			tabs.init();
		});
		jQuery(document).ready(function($) {
			$('#form_1, #form_2, #form_3').jqTransform({
				imgPath : 'jqtransformplugin/img/'
			});
		});
		$(window).load(function() {
			$('#slider').nivoSlider({
				effect : 'fade', //Specify sets like: 'fold,fade,sliceDown, sliceDownLeft, sliceUp, sliceUpLeft, sliceUpDown, sliceUpDownLeft' 
				slices : 15,
				animSpeed : 500,
				pauseTime : 6000,
				startSlide : 0, //Set starting Slide (0 index)
				directionNav : false, //Next & Prev
				directionNavHide : false, //Only show on hover
				controlNav : false, //1,2,3...
				controlNavThumbs : false, //Use thumbnails for Control Nav
				controlNavThumbsFromRel : false, //Use image rel for thumbs
				controlNavThumbsSearch : '.jpg', //Replace this with...
				controlNavThumbsReplace : '_thumb.jpg', //...this in thumb Image src
				keyboardNav : true, //Use left & right arrows
				pauseOnHover : true, //Stop animation while hovering
				manualAdvance : false, //Force manual transitions
				captionOpacity : 1, //Universal caption opacity
				beforeChange : function() {
				},
				afterChange : function() {
				},
				slideshowEnd : function() {
				} //Triggers after all slides have been shown
			});
		});
	</script>
</body>
</html>