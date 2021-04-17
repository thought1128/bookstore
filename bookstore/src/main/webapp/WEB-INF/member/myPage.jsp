<%@page import="member.model.Member"%>
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

<script type="text/javascript">
	function cancelOrder(orderNum){
		location.href= "/bookstore/cancelOrder.me?orderNum="+orderNum
	}
	function refundOrder(orderNum){
		location.href= "/bookstore/refundOrder.me?orderNum="+orderNum
	}
	
</script>

<%@ include file="./../../book_nav.jsp"%>
<%@ include file="./memberTop.jsp"%>
<h4 align="right">나의 현재 포인트 : ${sessionScope.loginInfo.point }point</h4>


<center >
	<h2>배송현황</h2>
	<table class="table table-hover mx-auto" style="width: 700px;" >
		<tr>
			<th>결재 완료/배송 준비중</th>
			<th>${beforeDeliveryCount }</th>
			<th>배송중</th>
			<th>${onDeliveryCount }</th>
			<th>배송완료</th>
			<th>${afterDeliveryCount }</th>
			<th>취소/반품/교환</th>
			<th>${cancelDeliveryCount }</th>
		</tr>

	</table>

	<h2>주문내역</h2>
	<table class="table table-hover mx-auto" style="width: 1400px;">

		<tr>
			<th>주문번호</th>
			<th>주문일자</th>
			<th>송장번호</th>
			<th>수취인</th>
			<th>주소</th>
			<th>배송상태</th>
			<th>가격</th>
			<th>비고</th>
			<th>교환/환불/취소 요청</th>

		</tr>
		<c:forEach items="${list }" var="orders">
			<tr>
				<th><a href="memberOProductDetail.me?orderNum=${orders.orderNum }">${orders.orderNum }</a></th>
				<th>${orders.orderDate }</th>
				<th>${orders.trackNum }</th>
				<th>${orders.name }</th>
				<th>${orders.address }</th>
				
				<c:if
					test="${orders.status eq '고객 주문취소' or orders.status eq '관리자 주문취소'or orders.status eq '환불완료'or orders.status eq '교환완료'}">
					<th class="table-danger">${orders.status }</th>
				</c:if>
				<c:if
					test="${orders.status eq '고객 주문취소 요청' or orders.status eq '환불요청' or orders.status eq '교환요청'}">
					<th class="table-warning">${orders.status }</th>
				</c:if>
				<c:if
					test="${orders.status eq '' or orders.status eq '결재 완료'or orders.status eq '배송전'}">
					<th class="table-primary">${orders.status }</th>
				</c:if>

				<c:if test="${orders.status eq '배송완료'or orders.status eq '배송중'}">
					<th class="table-success">${orders.status }</th>
				</c:if>
				<th>${orders.totalPrice }</th>
				
				<th>${orders.reason }</th>
				<c:if test="${orders.status eq '결재 완료' or orders.status eq '배송전'}">
					<th><input type="button" value="주문 취소" class="btn btn-warning"
						onclick="cancelOrder(${orders.orderNum })"></th>
				</c:if>
				<c:if test="${orders.status eq '배송중' or orders.status eq '배송완료'}">
					<th><input type="button" value="교환/환불 요청"
						class="btn btn-warning" onclick="refundOrder(${orders.orderNum })"></th>
				</c:if>
				<c:if
					test="${orders.status ne '배송중' and orders.status ne '배송완료'and orders.status ne '결재 완료'and orders.status ne '배송전'}">
					<th></th>
				</c:if>
			</tr>

		</c:forEach>

	</table>
</center>
<%@ include file="./../../footer.jsp"%>