<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="profile_info">
	<div>
		<p style="padding-left: 0px;">
			<strong><legend>
					<spring:message code="changeEmail.profileInfo" />
				</legend></strong>
		</p>
		<div style="margin-right: 70px">
			<p
				style="padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
				<strong><spring:message code="changeEmail.username" /></strong>
				<c:out value="${ username}"></c:out>
			</p>
			<p
				style="padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
				<strong><spring:message code="changeEmail.email" /></strong>
				<c:out value="${ email}"></c:out>
			</p>
			<p
				style="padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
				<strong> <spring:message code="baggage.firstName" />
				</strong>
				<c:out value="${ firstName}"></c:out>
			</p>
			<p
				style="padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
				<strong> <spring:message code="baggage.lastName" />
				</strong>
				<c:out value="${ lastName}"></c:out>
			</p>
			<p
				style="padding-top: 25px; width: 450px; padding-left: 20px; padding: 8px 6px; height: 22px; width: 280px; padding-bottom: 18px; padding-left: 15px; border-width: thin; border-radius: 3px; border: 1px solid rgba(4, 129, 177, 0.5);">
				<strong> <spring:message code="changeEmail.phonenumber" />
				</strong>
				<c:out value="${ phone}"></c:out>
			</p>
			<br>
		</div>
	</div>
</div>