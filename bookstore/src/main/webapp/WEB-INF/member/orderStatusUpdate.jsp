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
<center>
	<h1>주문 상태 변경</h1>

	<form action="updateStatus.me" method="post">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-1">주문 번호 </div>
			<div class="col-md-2">
				<input type="text" name="orderNum" value="${orderNum}"
					class="form-control" readonly="readonly">
			</div>
		</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-1">주문 상태 </div>
			<div class="col-md-1">
				<select name="status" class="form-select">
					<option value="결재 완료">결재 완료</option>
					<option value="배송전">배송전</option>
					<option value="배송중">배송중</option>
					<option value="배송완료">배송완료</option>
					<option value="환불요청">환불요청</option>
					<option value="교환요청">교환요청</option>
					<option value="고객 주문취소 요청">고객 주문취소 요청</option>
					<option value="고객 주문취소">고객 주문취소</option>
					<option value="관리자 주문취소">관리자 주문취소</option>
					<option value="환불완료">환불완료</option>
					<option value="교환완료">교환완료</option>
				</select>
			</div>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<textarea rows="5" cols="65" name="reason"></textarea>
				</div>
			</div>
			<div class="row">
				<div class="col-md-7"></div>
				<div class="col-md-1">
					<input type="submit" value="상태 변경" class="btn btn-primary">
				</div>
			</div>
		</div>
	</form>
</center>
<%@ include file="./../../footer.jsp"%>