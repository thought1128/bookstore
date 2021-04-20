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
		function updateStatus(orderNum){
			location.href = "updateStatus.me?orderNum="+orderNum;
		}
		function insertTrackNum(orderNum){
			location.href = "insertTrackNum.me?orderNum="+orderNum;
		}
	</script>

<%@ include file="./../../book_nav.jsp"%>
<%@ include file="./adminTop.jsp"%>

			<h1 align="center">주문 리스트</h1>
			<form action="adminMain.prd" method="post">
				<div class="row">
					<div class="col-md-5"></div>
					<div class="col-md-2">
						<select name="keyword" class="form-select" style="width: 200px">
							<option value="">전체 검색
							<option value="결재 완료">결재 완료
							<option value="배송전">배송전
							<option value="배송중">배송중
							<option value="배송완료">배송완료
							<option value="환불요청">환불요청
							<option value="교환요청">교환요청
							<option value="고객 주문취소 요청">고객 주문취소 요청
							<option value="고객 주문취소">고객 주문취소
							<option value="관리자 주문취소">관리자 주문취소
							<option value="환불완료">환불완료
							<option value="교환완료">교환완료
						</select>
					</div>
					<div class="col-md-1">
						<input type="submit" value="검색" class="btn btn-primary">
					</div>
				</div>
			</form>
			<table class="table table-hover table-bordered mx-auto" style="width: 100%;">
				<tr>
					<th><span>주문번호</span></th>
					<th><span>주문일자</span></th>
					<th><span>회원 번호</span></th>
					<th><span>수취인</span></th>
					<th><span>배송지</span></th>
					<th><span>휴대폰 번호</span></th>
					<th><span>택배 번호</span></th>
					<th><span>주문상태 </span></th>
					<th><span>전체가격</span></th>
					<th><span>전체포인트</span></th>
					<th><span>비고</span></th>
					<th><span>주문상태변경</span></th>
					<th><span>택배번호 입력</span></th>
				</tr>
				<c:forEach items="${orderMemberLists }" var="member">
					<tr>
						<th><a href="memberOProductDetail.me?orderNum=${member.orderNum }">${member.orderNum }</a></th>
						<th>${member.orderDate }</th>
						<th><a href="detail.me?memberNum=${member.memberNum }">${member.memberNum }</a>
							<!-- detail.me=> MemberDetailViewController --></th>
						<th>${member.name }</th>
						<th>${member.address }</th>
						<th>${member.phoneNum }</th>
						<th>${member.trackNum }</th>
						<c:if test="${member.status eq '고객 주문취소' or member.status eq '관리자 주문취소'or member.status eq '환불완료'or member.status eq '교환완료'}">
							<th class="table-danger">${member.status }</th></c:if>
						<c:if test="${member.status eq '고객 주문취소 요청' or member.status eq '환불요청' or member.status eq '교환요청'}">
							<th class="table-warning">${member.status }</th></c:if>
						<c:if test="${member.status eq '' or member.status eq '결재 완료'or member.status eq '배송전'}">
							<th class="table-primary">${member.status }</th></c:if>
						<c:if test="${member.status eq '배송완료'or member.status eq '배송중'}">
							<th class="table-success">${member.status }</th></c:if>
						<th>${member.totalPrice }</th>
						<th>${member.totalPoint }</th>
						<th>${member.reason}</th>
						<th><c:if test="${member.status ne '고객 주문취소' and member.status ne '관리자 주문취소'and member.status ne '환불완료' and member.status ne '교환완료'}">
							<input type="button" value="주문상태변경" class="btn btn-primary" onclick="updateStatus(${member.orderNum})"></c:if>
						</th>
						<th><c:if test="${member.status eq '' or member.status eq '결재 완료'or member.status eq '배송전'}">
							<input type="button" value="택배번호 입력" class="btn btn-primary" onclick="insertTrackNum(${member.orderNum})"></c:if>
						</th>
					</tr>
				</c:forEach>
			</table>
<center>${pageInfo.pagingHtml }</center>
<%@ include file="./../../footer.jsp"%>