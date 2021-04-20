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
	<%@ include file="./../../book_nav.jsp"%>
	<%@ include file="./../admin/adminTop.jsp"%>

<center>
	<table class="table table-hover table-bordered mx-auto" style="width: 1200px;">
		<tr>
			<th colspan="7">회원정보</th>
		</tr>
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>휴대폰 번호</th>
			<th>이메일 주소</th>
			<th>주소</th>
			<th>적립 포인트</th>
		</tr>
		<tr>
			<th>${memberDetail.memberNum}</th>
			<th>${memberDetail.id}</th>
			<th>${memberDetail.name}</th>
			<th>${memberDetail.phoneNum}</th>
			<th>${memberDetail.email}</th>
			<th>${memberDetail.address}</th>
			<th>${memberDetail.point}</th>
		</tr>
	</table>

	<table class="table table-hover mx-auto" style="width: 800px;">
		<tr>
			<th colspan="8">주문 정보</th>
		</tr>
		<tr>
			<th>주문 번호</th>
			<th>수취인</th>
			<th>배송지</th>
			<th>휴대폰 번호</th>
			<th>택배 번호</th>
			<th>주문상태</th>
			<th>전체 가격</th>
			<th>전체 포인트</th>
		</tr>

		<c:forEach items="${orderList}" var="list">
			<tr>
				<th><a href="memberOProductDetail.me?orderNum=${list.orderNum}">${list.orderNum}</a></th>
				<th>${list.name}</th>
				<th>${list.address}</th>
				<th>${list.phoneNum}</th>
				<th>${list.trackNum}</th>
				<c:if test="${list.status eq '고객 주문취소' or list.status eq '관리자 주문취소'or list.status eq '환불완료'or list.status eq '교환완료'}">
					<th class="table-danger">${list.status }</th>
				</c:if>
				<c:if test="${list.status eq '고객 주문취소 요청' or list.status eq '환불요청' or list.status eq '교환요청'}">
					<th class="table-warning">${list.status }</th>
				</c:if>
				<c:if test="${list.status eq '' or list.status eq '결재 완료'or list.status eq '배송전'}">
					<th class="table-primary">${list.status }</th>
				</c:if>
				<c:if test="${list.status eq '배송완료'or list.status eq '배송중'}">
					<th class="table-success">${list.status }</th>
				</c:if>
				<th>${list.totalPrice}</th>
				<th>${list.totalPoint}</th>
			</tr>
		</c:forEach>

	</table>

</center>
<%@ include file="./../../footer.jsp"%>