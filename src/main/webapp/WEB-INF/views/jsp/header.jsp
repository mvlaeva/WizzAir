<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<header>
<script type="text/javascript">
function dodajAktywne(elem) {
    var a = document.getElementsByTagName('li')
    for (i = 0; i < a.length; i++) {
        a[i].classList.remove('menu_active')
    }
    elem.classList.add('menu_active');
}
</script>
	<div class="wrapper">
		<h1>
			<a href="./Home" id="logo"><spring:message code="index.header" /></a>
		</h1>
		<span id="slogan"><spring:message code="index.header.span" /></span>
		<nav id="top_nav">
			<ul>
				<c:if test="${ empty user  }">
					<li><a href="./Login" class="nav2"><spring:message
								code="index.login" /></a></li>
				</c:if>
				<c:if test="${ not empty user }">
					<li><a href="./Logout" class="nav2"><spring:message
								code="index.logout" /></a></li>
				</c:if>
				<li><a href="./Contacts" class="nav3"><spring:message
							code="index.contacts" /></a></li>
				<li><a href="?language=en">EN</a>&nbsp;<a href="?language=de">DE</a>&nbsp;<a
					href="?language=bg">BG</a></li>

			</ul>
		</nav>
	</div>
	<nav>
		<ul id="menu">
			<li id="menu_active" onclick="dodajAktywne(this)" ><a href="./Home"><span><span><spring:message
								code="index.about" /></span></span></a></li>
			<li id="a-home" onclick="dodajAktywne(this)"><a href="./Offers"><span><span><spring:message
								code="index.offers" /></span></span></a></li>
			<li id="a-home" onclick="dodajAktywne(this)"><a href="./Book"><span><span><spring:message
								code="index.book" /></span></span></a></li>
			<li id="a-home" onclick="dodajAktywne(this)"><a href="./Safety"><span><span><spring:message
								code="index.safety" /></span></span></a></li>
			<li class="end"><a href="./Contacts"><span><span><spring:message
								code="index.contacts" /></span></span></a></li>
			<c:if test="${not empty user }">
				<li id="a-home" onclick="dodajAktywne(this)"><a href="./Profile"><span><span><spring:message
									code="index.profile" /></span></span></a></li>
			</c:if>
		</ul>
	</nav>
</header>