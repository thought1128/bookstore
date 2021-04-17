<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<!-- Bootstrap JS -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap"
	rel="stylesheet">

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<%@ include file="./../../book_nav.jsp"%>
<%@ include file="./memberTop.jsp"%>
<center>
<h2>취소/반품/교환/환불 내역</h2>
<table class="table table-hover mx-auto" style="width: 800px;">
	
	<tr>
		<td>주문번호</td>
		<td>주문일자</td>
		<td>송장번호</td>
		<td>수취인</td>
		<td>주소</td>
		<td>배송상태</td>
		<td>가격</td>
		
	</tr>
	<c:forEach items="${list }" var="orders">
		<tr>
			<td><a href="memberOProductDetail.me?orderNum=${orders.orderNum }">${orders.orderNum }</a></td>
			<td>${orders.orderDate }</td>
			<td>${orders.trackNum }</td>
			<td>${orders.name }</td>
			<td>${orders.address }</td>
			<td <c:if test="${orders.status eq '고객 주문취소' or member.status eq '관리자 주문취소'}">class="table-danger"</c:if>>${orders.status }</td>
			<td>${orders.totalPrice }</td>
		
		</tr>
	
	</c:forEach>

</table>
</center>
<%@ include file="./../../footer.jsp"%>